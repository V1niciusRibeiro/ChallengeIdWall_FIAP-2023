package br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.APICaller;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol.InterpolImages;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol.InterpolJsons;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol.InterpolNotice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterpolJsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String[] noticesCategories = {"red", "yellow", "un"};
    private static final List<InterpolJsons> interpolJsonsArray = new ArrayList<>();

    public static List<InterpolJsons> generateJsonData(String json) {

        System.out.println("Gerou DATA INterpol");

        try {
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            if (hasNoticeCategories(jsonObject)) {
                processNoticeCategories(jsonObject);
                return interpolJsonsArray;
            } else if (jsonObject.has("entity_id")) {
                processNotice(jsonObject);
                return interpolJsonsArray;
            } else {
                System.err.println("Invalid Json!");
                return interpolJsonsArray;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return interpolJsonsArray;
        }
    }

    private static boolean hasNoticeCategories(JsonObject jsonObject) {
        return Arrays.stream(noticesCategories).anyMatch(jsonObject::has);
    }

    private static void processNoticeCategories(JsonObject jsonObject) throws JsonProcessingException {
        for (String noticecategory : noticesCategories) {
            if (jsonObject.has(noticecategory)) {

                JsonObject notices = jsonObject.getAsJsonObject(noticecategory);
                JsonObject links = notices.getAsJsonObject("_links");
                int lastPage = getLastPageNumber(links);

                for (int page = 1; page <= lastPage; page++) {
                    JsonArray wantedJsonArray = getArray(notices.getAsJsonObject("_embedded"), "notices");

                    processNotices(wantedJsonArray);

                    if (page != lastPage) {
                        String nextHref = links.getAsJsonObject("next").get("href").getAsString();
                        notices = JsonParser.parseString(APICaller.performAPICall(nextHref)).getAsJsonObject();
                    }
                }
            }
        }
    }

    private static int getLastPageNumber(JsonObject links) {
        String lastHref = links.getAsJsonObject("last").get("href").getAsString();
        char lastChar = lastHref.charAt(lastHref.length() - 1);
        return Character.isDigit(lastChar) ? Character.getNumericValue(lastChar) : 1;
    }

    private static void processNotices(JsonArray wantedJsonArray) throws JsonProcessingException {

        for (JsonElement wantedJson : wantedJsonArray) {
            if (wantedJson.isJsonObject()) {
                JsonObject notice = getNoticeFromJson(wantedJson);

                interpolJsonsArray.add(new InterpolJsons(processNotice(notice)
                                                        ,processNoticeImages(notice)));

            }
        }
    }

    private static JsonObject getNoticeFromJson(JsonElement wantedJson) {
        String selfHref = wantedJson.getAsJsonObject()
                .getAsJsonObject("_links")
                .getAsJsonObject("self")
                .get("href").getAsString();
        return JsonParser.parseString(APICaller.performAPICall(selfHref)).getAsJsonObject();
    }

    private static InterpolNotice processNotice(JsonObject notice) throws JsonProcessingException {
        return objectMapper.readValue(notice.toString(), InterpolNotice.class);
    }

    private static InterpolImages processNoticeImages(JsonObject notice) throws JsonProcessingException {
        return objectMapper.readValue(getNoticeImagesFromJson(notice).toString(), InterpolImages.class);
    }

    private static JsonObject getNoticeImagesFromJson(JsonObject notice) {
        String selfHref = notice.getAsJsonObject("_links")
                .getAsJsonObject("images")
                .get("href").getAsString();
        return JsonParser.parseString(APICaller.performAPICall(selfHref)).getAsJsonObject();
    }
    private static JsonArray getArray(JsonObject jsonObject, String key) {
        JsonElement element = jsonObject.get(key);
        if (element != null && !element.isJsonNull() && element.isJsonArray()) {
            return element.getAsJsonArray();
        }
        return new JsonArray();
    }

}

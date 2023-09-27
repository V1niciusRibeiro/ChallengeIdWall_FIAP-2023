package br.com.fiap.ChallengeIdWall.DataBase;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManeger.InterpolAPI;
import br.com.fiap.ChallengeIdWall.Model.entity.Wanted;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LoadDB {

//    private static final String ENTITY_ID_PREFIX = "Wanted by Interpol - Entity ID: ";
//
//    private LoadDB() {
//    }
//
//    public static void populateDB(String json) {
//        try {
//            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
//            JsonObject notices = jsonObject.getAsJsonObject("red");
//            JsonObject links = notices.getAsJsonObject("_links");
//
//            int page = notices.getAsJsonObject("query").get("page").getAsInt();
//            String href = links.getAsJsonObject("last").get("href").getAsString();
//
//            int lastPage = getLastPageNumber(href);
//
//            do {
//                JsonArray wantedJsonArray = notices.getAsJsonObject("_embedded")
//                        .getAsJsonArray("notices");
//
//                processWantedEntities(wantedJsonArray);
//
//                if (page != lastPage) {
//                    href = getNextPageHref(links);
//                    notices = JsonParser.parseString(InterpolAPI.getInstance().performAPICall(href)).getAsJsonObject();
//                }
//
//            } while (++page <= lastPage);
//        } catch (Exception e) {
//            handleException(e);
//        }
//    }
//
//    private static int getLastPageNumber(String href) {
//        char lastChar = href.charAt(href.length() - 1);
//        return Character.isDigit(lastChar) ? Character.getNumericValue(lastChar) : 1;
//    }
//
//    private static void processWantedEntities(JsonArray wantedJsonArray) {
//        for (JsonElement wantedJson : wantedJsonArray) {
//            if (wantedJson.isJsonObject()) {
//                JsonObject entity = getEntityFromJson(wantedJson);
//                Wanted wanted = createWantedFromEntity(entity);
//                System.out.println(wanted);
//            }
//        }
//    }
//
//    private static JsonObject getEntityFromJson(JsonElement wantedJson) {
//        String selfHref = wantedJson.getAsJsonObject()
//                .getAsJsonObject("_links")
//                .getAsJsonObject("self")
//                .get("href").getAsString();
//
//        return JsonParser.parseString(InterpolAPI.getInstance().performAPICall(selfHref)).getAsJsonObject();
//    }
//
//    private static Wanted createWantedFromEntity(JsonObject entity) {
//        String wantedWeight = getStringOrDefault(entity, "weight", "");
//        String wantedHeight = getStringOrDefault(entity, "height", "");
//        String wantedSex = getStringOrDefault(entity, "sex_id", "");
//        String wantedDescription = getStringOrDefault(entity, "distinguishing_marks", "");
//        String wantedEye = getArrayAsString(entity.getAsJsonArray("eyes_colors_id"));
//        String wantedHair = getArrayAsString(entity.getAsJsonArray("hairs_id"));
//        String wantedPlaceOfBirth = getStringOrDefault(entity, "place_of_birth", "") +
//                " - " + getStringOrDefault(entity, "country_of_birth_id", "");
//
//        return new Wanted(0, "", wantedWeight, wantedEye, wantedHeight,
//                wantedHair, wantedSex, wantedPlaceOfBirth,
//                ENTITY_ID_PREFIX + getStringOrDefault(entity, "entity_id", ""), wantedDescription, "");
//    }
//
//    private static String getStringOrDefault(JsonObject jsonObject, String key, String defaultValue) {
//        JsonElement element = jsonObject.get(key);
//        if (element != null && !element.isJsonNull()) {
//            return element.getAsString();
//        }
//        return defaultValue;
//    }
//
//    private static String getArrayAsString(JsonArray jsonArray) {
//        StringBuilder result = new StringBuilder();
//        for (JsonElement element : jsonArray) {
//            result.append(element.getAsString()).append(" | ");
//        }
//        return result.toString();
//    }
//
//    private static String getNextPageHref(JsonObject links) {
//        return links.getAsJsonObject("next").get("href").getAsString();
//    }
//
//    private static void handleException(Exception e) {
//        System.err.println(e.getMessage());
//    }
}

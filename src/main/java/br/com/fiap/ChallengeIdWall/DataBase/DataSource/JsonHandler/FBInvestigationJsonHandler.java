package br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.APICaller;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.FBI.FBIWantedPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;

public class FBInvestigationJsonHandler {

    private static final int ITEMS_PER_PAGE = 50;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<FBIWantedPerson> generateJsonData(String apiUrl) {

        System.out.println("Gerou DATA FBI");
        List<FBIWantedPerson> resultList = new ArrayList<>();

        try {
            apiUrl = apiUrl + "&page=1";
            String json = apiResponseToJson(APICaller.performAPICall(apiUrl));
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            if (jsonObject.has("total")) {
                int totalItems = jsonObject.get("total").getAsInt();
                int lastPage = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

                for (int page = 1; page <= lastPage; page++) {
                    JsonArray items = jsonObject.getAsJsonArray("items");

                    for (JsonElement item : items) {
                        FBIWantedPerson wantedPerson = objectMapper.readValue(item.toString(), FBIWantedPerson.class);
                        resultList.add(wantedPerson);
                    }

                    if (page != lastPage) {
                        apiUrl = apiUrl.replace("&page=" + page, "&page=" + (page + 1));
                        jsonObject = JsonParser.parseString(apiResponseToJson(APICaller.performAPICall(apiUrl))).getAsJsonObject();
                    }
                }
            } else if (jsonObject.has("@id")) {
                FBIWantedPerson wantedPerson = objectMapper.readValue(jsonObject.toString(), FBIWantedPerson.class);
                resultList.add(wantedPerson);
            } else {
                throw new IllegalArgumentException("Invalid JSON");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    private static String apiResponseToJson(String apiResponse) {
        String json = Jsoup.parse(apiResponse).body().text();

        json = json.replace("None", "null");
        json = json.replace("\\\\xa0", "");
        json = json.replace("\\xa0", "");
        json = json.replace("\\xa0D", "");
        json = json.replace("\\xa0A", "");
        json = json.replace("\"","<?>ASPAS</?>");
        json = json.replace("'","\"");
        json = json.replace("<?>ASPAS</?>","'");

        return json;
    }
}


package br.com.fiap.ChallengeIdWall.Model.DataSource;

import br.com.fiap.ChallengeIdWall.Model.DataSource.Interpol.InterpolAPI;
import com.google.gson.*;

import java.util.List;

public class LoadDB {


    private LoadDB() {}

    public static void populateDB(String json) {

        try {

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            JsonObject notices = jsonObject.getAsJsonObject("red");
            JsonObject links = notices.getAsJsonObject("_links");

            int page = notices.getAsJsonObject("query").get("page").getAsInt();
            String href = links.getAsJsonObject("last").get("href").getAsString();

            char lastChar = href.charAt(href.length() - 1);
            int lastPage = Character.isDigit(lastChar) ? Character.getNumericValue(lastChar) : 1;

            do {

                JsonArray wantedArray = notices.getAsJsonObject("_embedded")
                        .getAsJsonArray("notices");

                for (JsonElement wanted : wantedArray) {
                    if (wanted.isJsonObject()) {

                        String selfHref = wanted.getAsJsonObject()
                                .getAsJsonObject("_links")
                                .getAsJsonObject("self")
                                .get("href").getAsString();

                        JsonObject entity = JsonParser.parseString(InterpolAPI.getInstance()
                                .performAPICall(selfHref)).getAsJsonObject();

                        System.out.println(entity);

                    }
                }

                if (page != lastPage) {
                    href = links.getAsJsonObject("next").get("href").getAsString();
                    notices = JsonParser.parseString(InterpolAPI.getInstance().performAPICall(href)).getAsJsonObject();
                    page++;
                }

            } while (page <= lastPage);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}


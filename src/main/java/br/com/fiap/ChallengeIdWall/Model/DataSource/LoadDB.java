package br.com.fiap.ChallengeIdWall.Model.DataSource;

import com.google.gson.*;

public class LoadDB {


    private LoadDB() {}

    public static void populateDB(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

//        System.out.println(jsonObject.get("red").getAsJsonObject());

    }

}

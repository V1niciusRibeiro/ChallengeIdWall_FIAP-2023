package br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler;
import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager.FBInvestigationAPI;

public class FBInvestigationJson {

    public static String jsonToString() {
        var jsonList = FBInvestigationAPI.getJsonList();

        StringBuilder concatenatedJson = new StringBuilder();

        for (String json : jsonList) {
            concatenatedJson.append(json);
        }

        return concatenatedJson.toString();
    }
}

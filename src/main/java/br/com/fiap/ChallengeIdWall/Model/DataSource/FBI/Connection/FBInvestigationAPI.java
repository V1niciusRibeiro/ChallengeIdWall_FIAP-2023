package br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.Connection;

import br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.FBInvestigationJson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FBInvestigationAPI  {

    static String urlWithPage = "https://api.fbi.gov/wanted/v1/list?page=";
    static int currentPage = 1;
    static int totalPages = 100;
    static List<String> jsonList = new ArrayList<>();
    public static void getCleanJson() {
        while (currentPage <= totalPages) {
            try {
                Connection connection = Jsoup.connect(urlWithPage + currentPage).timeout(30 * 1000);
                connection.ignoreContentType(true);
                Document doc = connection.get();
                String bodyContent = doc.body().text();

                if (bodyContent.startsWith("{")) {
                    if (!bodyContent.contains("\"hair_raw\"")) {
                        break;
                    }
                    jsonList.add(bodyContent);
                    currentPage++;
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        /*
        for (String json : jsonList) {
            System.out.println(json);
        }
        */
    }
}

package br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class FBInvestigationJson {
    static String urlWithPage = "https://api.fbi.gov/wanted/v1/list?page=";
    static int currentPage = 50;
    static int totalPages = 100;
    static String json;
    public static void getCleanJson() {
        while (true) {
            try {
                Document doc = Jsoup.connect( urlWithPage + currentPage).get();
                String bodyContent = doc.body().text();
                if (bodyContent.startsWith("{")) {

                    System.out.println((bodyContent));

                    Element nextPageLink = doc.select("link[rel=next]").first();
                    if (nextPageLink == null) {
                        break;
                    }
                    currentPage++;
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}


package br.com.fiap.ChallengeIdWall.Model.DataSource.Interpol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class InterpolAPI {

    private static InterpolAPI instance;

    private static final String baseURL = "https://ws-public.interpol.int/notices/v1/";
    private static final String[] notices = {"red","yellow","un"};

    private String noticeID;
    private String foreName;
    private String name;
    private String nationality;
    private int ageMin;
    private int ageMax;
    private String freeText;
    private String sexId;
    private String arrestWarrantCountryId;
    private int page;
    private int resultPerPage;

    private InterpolAPI() {}

    public static InterpolAPI getInstance() {
        if (instance == null) {
            instance = new InterpolAPI();
        }
        return instance;
    }

    public InterpolAPI setNoticeID(String noticeID){
        this.noticeID = noticeID;
        return this;
    }

    public InterpolAPI setForeName(String foreName) {
        this.foreName = foreName;
        return this;
    }

    public InterpolAPI setName(String name) {
        this.name = name;
        return this;
    }

    public InterpolAPI setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public InterpolAPI setAgeMin(int ageMin) {
        this.ageMin = ageMin;
        return this;
    }

    public InterpolAPI setAgeMax(int ageMax) {
        this.ageMax = ageMax;
        return this;
    }

    public InterpolAPI setFreeText(String freeText) {
        this.freeText = freeText;
        return this;
    }

    public InterpolAPI setSexId(String sexId) {
        this.sexId = sexId;
        return this;
    }

    public InterpolAPI setArrestWarrantCountryId(String arrestWarrantCountryId) {
        this.arrestWarrantCountryId = arrestWarrantCountryId;
        return this;
    }

    public InterpolAPI setPage(int page) {
        this.page = page;
        return this;
    }

    public InterpolAPI setResultPerPage(int resultPerPage) {
        this.resultPerPage = resultPerPage;
        return this;
    }

    public String execute() {

        StringBuilder apiFinalResponse = new StringBuilder();

        if (noticeID != null) {
            apiFinalResponse.append(performAPICall(baseURL+noticeID));
        }else {

            apiFinalResponse.append("{");

            for (int i = 0; i < notices.length; i++) {

                String notice = notices[i];

                String apiUrl = baseURL + notice;

                StringBuilder queryString = new StringBuilder("?");

                if (foreName != null) {
                    queryString.append("forename=").append(foreName).append("&");
                }

                if (name != null) {
                    queryString.append("name=").append(name).append("&");
                }

                if (nationality != null) {
                    queryString.append("nationality=").append(nationality).append("&");
                }

                if (ageMin > 0) {
                    queryString.append("ageMin=").append(ageMin).append("&");
                }

                if (ageMax > 0) {
                    queryString.append("ageMax=").append(ageMax).append("&");
                }

                if (freeText != null) {
                    queryString.append("freeText=").append(freeText).append("&");
                }

                if (sexId != null) {
                    queryString.append("sexId=").append(sexId).append("&");
                }

                if (arrestWarrantCountryId != null) {
                    queryString.append("arrestWarrantCountryId=").append(arrestWarrantCountryId).append("&");
                }

                if (page >= 1) {
                    queryString.append("page=").append(page).append("&");
                }

                if (resultPerPage >= 1) {
                    queryString.append("resultPerPage=").append(resultPerPage).append("&");
                }

                String apiResponse = performAPICall(apiUrl + queryString.toString());

                String responseDivisor = (i == notices.length - 1) ? "" : ",";

                apiFinalResponse.append('"').append(notice).append('"').append(":").append(apiResponse).append(responseDivisor);
            }
            apiFinalResponse.append("}");
        }

        return apiFinalResponse.toString();
    }

    public String performAPICall(String apiUrl) {
        try {

            URL url = URI.create(apiUrl).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            } else {
                System.err.println("Erro na requisição. Código de resposta: " + responseCode);
                return null;
            }

        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

}

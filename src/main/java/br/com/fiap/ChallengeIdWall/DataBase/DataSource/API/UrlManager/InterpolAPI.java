
package br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.APICaller;

public class InterpolAPI {

    private InterpolAPI() { }
    private static InterpolAPI instance;
    public static InterpolAPI getInstance() {
        if (instance == null) {
            instance = new InterpolAPI();
        }
        return instance;
    }

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

        StringBuilder apiUrl = new StringBuilder(baseURL);
        StringBuilder apiResponse = new StringBuilder();

        if (noticeID != null) {
            apiUrl.append(noticeID);
            apiResponse.append(APICaller.performAPICall(apiUrl.toString()));
        } else {
            apiResponse.append("{");
            for (String notice : notices) {

                apiUrl.replace(baseURL.length(),apiUrl.length(),notice+"?");
                apiResponse.append('"').append(notice).append('"').append(":");

                appendQueryParam(apiUrl, "forename", foreName);
                appendQueryParam(apiUrl, "name", name);
                appendQueryParam(apiUrl, "nationality", nationality);
                appendQueryParam(apiUrl, "ageMin", ageMin);
                appendQueryParam(apiUrl, "ageMax", ageMax);
                appendQueryParam(apiUrl, "freeText", freeText);
                appendQueryParam(apiUrl, "sexId", sexId);
                appendQueryParam(apiUrl, "arrestWarrantCountryId", arrestWarrantCountryId);
                appendQueryParam(apiUrl, "page", page);
                appendQueryParam(apiUrl, "resultPerPage", resultPerPage);

                apiUrl.setLength(apiUrl.length() - 1); // Remove o último "&"  ou "?" desnecessário
                apiResponse.append(APICaller.performAPICall(apiUrl.toString())).append(",");
            }
            apiResponse.setLength(apiResponse.length() - 1); // Remove a última vírgula desnecessária
            apiResponse.append("}");
        }

        return apiResponse.toString();
    }

    private void appendQueryParam(StringBuilder apiUrl, String paramName, Object paramValue) {
        if (paramValue != null && !"0".equals(paramValue.toString())) {
            apiUrl.append(paramName).append("=").append(paramValue).append("&");
        }
    }


}

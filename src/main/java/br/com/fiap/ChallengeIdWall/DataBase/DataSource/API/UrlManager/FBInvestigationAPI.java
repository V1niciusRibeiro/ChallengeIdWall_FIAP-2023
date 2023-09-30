package br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.UrlManager;


public class FBInvestigationAPI {

    private FBInvestigationAPI() {
    }

    private static FBInvestigationAPI instance;

    public static FBInvestigationAPI getInstance() {
        if (instance == null) {
            instance = new FBInvestigationAPI();
        }
        return instance;
    }

    private static final String baseURL = "https://api.fbi.gov/@wanted";

    private String id;
    private String sortOn;
    private String sortOrder;
    private String title;
    private String fieldOffices;
    private String personClassification;
    private String posterClassification;
    private String status;

    public FBInvestigationAPI setId(String id) {
        this.id = id;
        return this;
    }

    public FBInvestigationAPI setSortOn(String sortOn) {
        this.sortOn = sortOn;
        return this;
    }

    public FBInvestigationAPI setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public FBInvestigationAPI setTitle(String title) {
        this.title = title;
        return this;
    }

    public FBInvestigationAPI setFieldOffices(String fieldOffices) {
        this.fieldOffices = fieldOffices;
        return this;
    }

    public FBInvestigationAPI setPersonClassification(String personClassification) {
        this.personClassification = personClassification;
        return this;
    }

    public FBInvestigationAPI setPosterClassification(String posterClassification) {
        this.posterClassification = posterClassification;
        return this;
    }

    public FBInvestigationAPI setStatus(String status) {
        this.status = status;
        return this;
    }

    public String execute() {

        StringBuilder apiUrl = new StringBuilder(baseURL);

        if (id != null) {
            apiUrl.append("-person/").append(id);
        } else {

            apiUrl.append("?");
            appendQueryParam(apiUrl, "pageSize", 50);
            appendQueryParam(apiUrl, "sortOn", sortOn);
            appendQueryParam(apiUrl, "sortOrder", sortOrder);
            appendQueryParam(apiUrl, "title", title);
            appendQueryParam(apiUrl, "fieldOffices", fieldOffices);
            appendQueryParam(apiUrl, "personClassification", personClassification);
            appendQueryParam(apiUrl, "posterClassification", posterClassification);
            appendQueryParam(apiUrl, "status", status);

            apiUrl.setLength(apiUrl.length() - 1); // Remove o último "&"  ou "?" desnecessário
        }

        return apiUrl.toString();
    }

    private void appendQueryParam(StringBuilder apiUrl, String paramName, Object paramValue) {
        if (paramValue != null && !"0".equals(paramValue.toString())) {
            apiUrl.append(paramName).append("=").append(paramValue).append("&");
        }
    }

}

package br.com.fiap.ChallengeIdWall.DataBase.DataSource.JsonHandler;

import br.com.fiap.ChallengeIdWall.DataBase.DataSource.API.APICaller;
import br.com.fiap.ChallengeIdWall.Model.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

public class InterpolJson {

    private static final List<Wanted> wantedList = new ArrayList<>();
    private static final List<List<Identity>> identityList = new ArrayList<>();
    private static final List<List<Language>> languageList = new ArrayList<>();
    private static final List<List<SpokenLanguage>> spokenLanguageList = new ArrayList<>();
    private static final List<List<Country>> countryList = new ArrayList<>();
    private static final List<List<Nationality>> nationalityList = new ArrayList<>();
    private static final List<List<Warrant>> warrantList = new ArrayList<>();
    private static final List<List<Image>> imageList = new ArrayList<>();
    private static final String[] NOTICE_CATEGORIES = {"red", "yellow", "un"};

    public static String generateEntities(String json) {

        try {
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            if (hasNoticeCategories(jsonObject)) {
                processNoticeCategories(jsonObject);
            } else if (jsonObject.has("entity_id")) {
                processEntity(jsonObject);
            } else {
                System.err.println("Invalid Json!");
                return "";
            }

            Map<String, Object> jsonData = new HashMap<>();
            jsonData.put("wanted", wantedList);
            jsonData.put("identity", identityList);
            jsonData.put("language", languageList);
            jsonData.put("spokenLanguage", spokenLanguageList);
            jsonData.put("country", countryList);
            jsonData.put("nationality", nationalityList);
            jsonData.put("warrant", warrantList);
            jsonData.put("image", imageList);

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(jsonData);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "";
        }
    }

    private static boolean hasNoticeCategories(JsonObject jsonObject) {
        return Arrays.stream(NOTICE_CATEGORIES).anyMatch(jsonObject::has);
    }

    private static void processNoticeCategories(JsonObject jsonObject) throws JsonProcessingException {
        for (String category : NOTICE_CATEGORIES) {
            if (jsonObject.has(category)) {

                JsonObject notices = jsonObject.getAsJsonObject(category);
                JsonObject links = notices.getAsJsonObject("_links");
                int lastPage = getLastPageNumber(links);

                for (int page = 1; page <= lastPage; page++) {
                    JsonArray wantedJsonArray = getArray(notices.getAsJsonObject("_embedded"),"notices");

                    processEntities(wantedJsonArray);

                    if (page != lastPage) {
                        String nextHref = links.getAsJsonObject("next").get("href").getAsString();
                        notices = JsonParser.parseString(APICaller.performAPICall(nextHref)).getAsJsonObject();
                    }
                }
            }
        }
    }

    private static int getLastPageNumber(JsonObject links) {
        String lastHref = links.getAsJsonObject("last").get("href").getAsString();
        char lastChar = lastHref.charAt(lastHref.length() - 1);
        return Character.isDigit(lastChar) ? Character.getNumericValue(lastChar) : 1;
    }

    private static void processEntities(JsonArray wantedJsonArray) throws JsonProcessingException {

        for (JsonElement wantedJson : wantedJsonArray) {
            if (wantedJson.isJsonObject()) {
                JsonObject entity = getEntityFromJson(wantedJson);

                processEntity(entity);
            }
        }
    }

    private static JsonObject getEntityFromJson(JsonElement wantedJson) {
        String selfHref = wantedJson.getAsJsonObject()
                .getAsJsonObject("_links")
                .getAsJsonObject("self")
                .get("href").getAsString();
        return JsonParser.parseString(APICaller.performAPICall(selfHref)).getAsJsonObject();
    }

    private static void processEntity(JsonObject entity) {


        Wanted wanted = createWantedFromEntity(entity);
        wantedList.add(wanted);

        List<Identity> identities = createIdentityFromEntity(entity, wanted);
        identityList.add(identities);

        List<Language> languages = createLanguagesFromEntity(entity);
        languageList.add(languages);

        List<SpokenLanguage> spokenLanguages = createSpokenLanguages(wanted, languages);
        spokenLanguageList.add(spokenLanguages);

        List<Country> countries = createCountriesFromEntity(entity);
        countryList.add(countries);

        List<Nationality> nationalities = createNationalities(wanted, countries);
        nationalityList.add(nationalities);

        List<Warrant> warrants = createWarrantsFromEntity(entity, wanted);
        warrantList.add(warrants);

        List<Image> images = createImagesFromEntity(entity, wanted);
        imageList.add(images);
    }
    private static Wanted createWantedFromEntity(JsonObject entity) {
        String wantedWeight = getString(entity, "weight");
        String wantedHeight = getString(entity, "height");
        String wantedSex = getString(entity, "sex_id");
        String wantedDescription = getString(entity, "distinguishing_marks");
        String wantedEye = getArrayAsString(getArray(entity,"eyes_colors_id"));
        String wantedHair = getArrayAsString(getArray(entity,"hairs_id"));
        String wantedPlaceOfBirth = getString(entity, "place_of_birth") +
                " - " + getString(entity, "country_of_birth_id");

        return new Wanted(0, "", wantedWeight, wantedEye, wantedHeight,
                wantedHair, wantedSex, wantedPlaceOfBirth,
                "Wanted by Interpol" + getString(entity, "entity_id"), wantedDescription, "");
    }

    private static List<Identity> createIdentityFromEntity(JsonObject entity, Wanted wanted){
        List<Identity> identities = new ArrayList<>();
        String identitydName = getString(entity, "name");
        String identitydForeName = getString(entity, "forename");
        String identitydSex = getString(entity, "sex_id");
        String identitydBirthDate = getString(entity, "date_of_birth");
        identities.add(new Identity(0,identitydName,identitydForeName,identitydBirthDate,identitydSex,wanted));
        return identities;
    }

    private static List<Language> createLanguagesFromEntity(JsonObject entity){
        List<Language> languages = new ArrayList<>();
        JsonArray languagesJson = getArray(entity,"languages_spoken_ids");
        for (JsonElement languageJson : languagesJson){
            Language language = new Language(0,languageJson.getAsString());
            languages.add(language);
        }
        return languages;
    }

    private static List<SpokenLanguage> createSpokenLanguages(Wanted wanted, List<Language> languages){
        List<SpokenLanguage> spokenLanguages = new ArrayList<>();
        for (Language language : languages){
            SpokenLanguage spokenLanguage = new SpokenLanguage(0, language, wanted);
            spokenLanguages.add(spokenLanguage);
        }
        return spokenLanguages;
    }

    private static List<Country> createCountriesFromEntity(JsonObject entity){
        List<Country> countries = new ArrayList<>();
        JsonArray countriesJson = getArray(entity,"nationalities");
        for (JsonElement countryJson : countriesJson){
            Country country = new Country(0,countryJson.getAsString());
            countries.add(country);
        }
        return countries;
    }

    private static List<Nationality> createNationalities(Wanted wanted, List<Country> countries){
        List<Nationality> nationalities = new ArrayList<>();
        for (Country country : countries){
            Nationality nationality = new Nationality(0,wanted,country);
            nationalities.add(nationality);
        }
        return nationalities;
    }

    private static List<Warrant> createWarrantsFromEntity(JsonObject entity, Wanted wanted){
        List<Warrant> warrants = new ArrayList<>();
        JsonArray warrantsJson = getArray(entity,"arrest_warrants");
        for (JsonElement warrantJson : warrantsJson){
            if (warrantJson.isJsonObject()) {
                Country country = new Country(0, getString(warrantJson.getAsJsonObject(),"issuing_country_id"));
                String acusation = getString(warrantJson.getAsJsonObject(),"charge");
                String acusationTranslate = getString(warrantJson.getAsJsonObject(),"charge_translation");
                Warrant warrant = new Warrant(0, wanted, acusation, acusationTranslate, country);
                warrants.add(warrant);
            }
        }
        return warrants;
    }

    private static List<Image> createImagesFromEntity(JsonObject entity, Wanted wanted){
        List<Image> images = new ArrayList<>();
        String imagesLink = entity.getAsJsonObject("_links").getAsJsonObject("images")
                .get("href").getAsString();
        JsonArray imagesJson = getArray(JsonParser.parseString(APICaller.performAPICall(imagesLink)).getAsJsonObject()
                .getAsJsonObject("_embedded"),"images");
        for (JsonElement imageJson : imagesJson){
            String imageLink = imageJson.getAsJsonObject().getAsJsonObject("_links")
                    .getAsJsonObject("self").get("href").getAsString();
            Image image = new Image(0,wanted,imageLink,"","");
            images.add(image);
        }
        return images;
    }

    private static String getString(JsonObject jsonObject, String key) {
        JsonElement element = jsonObject.get(key);
        if (element != null && !element.isJsonNull()) {
            return element.getAsString();
        }
        return "";
    }

    private static JsonArray getArray(JsonObject jsonObject, String key){
        JsonElement element = jsonObject.get(key);
        if (element != null && !element.isJsonNull() && element.isJsonArray()) {
            return element.getAsJsonArray();
        }
        return new JsonArray();
    }

    private static String getArrayAsString(JsonArray jsonArray) {
        StringBuilder result = new StringBuilder();
        for (JsonElement element : jsonArray) {
            result.append(element.getAsString()).append(" | ");
        }
        return result.toString();
    }

}

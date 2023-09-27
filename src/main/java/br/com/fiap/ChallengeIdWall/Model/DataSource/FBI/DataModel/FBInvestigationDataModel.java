package br.com.fiap.ChallengeIdWall.Model.DataSource.FBI.DataModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FBInvestigationDataModel {
    @JsonProperty("hair_raw")
    private String hairWanted;

    @JsonProperty("description")
    private String description;

    @JsonProperty("reward_max")
    private int rewardMax;

    @JsonProperty("person_classification")
    private String personClassification;

    @JsonProperty("eyes")
    private String eyes;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("possible_countries")
    private List<String> possibleCountries;

    @JsonProperty("weight_max")
    private int weightMax;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("race_raw")
    private String raceRaw;

    @JsonProperty("warning_message")
    private String warningMessage;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("images")
    private List<ImageDataModel> images;

    @JsonProperty("field_offices")
    private List<String> fieldOffices;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("poster_classification")
    private String posterClassification;

    @JsonProperty("build")
    private String build;

    @JsonProperty("coordinates")
    private List<Double> coordinates;

    @JsonProperty("age_range")
    private String ageRange;

    @JsonProperty("scars_and_marks")
    private String scarsAndMarks;

    @JsonProperty("details")
    private String details;

    @JsonProperty("height_max")
    private int heightMax;

    @JsonProperty("path")
    private String path;

    @JsonProperty("caution")
    private String caution;

    @JsonProperty("publication")
    private String publication;

    @JsonProperty("complexion")
    private String complexion;

    @JsonProperty("files")
    private List<FileDataModel> files;

    @JsonProperty("locations")
    private List<String> locations;

    @JsonProperty("dates_of_birth_used")
    private List<String> datesOfBirthUsed;

    @JsonProperty("url")
    private String url;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("reward_min")
    private int rewardMin;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("status")
    private String status;

    @JsonProperty("aliases")
    private List<String> aliases;

    @JsonProperty("height_min")
    private int heightMin;

    @JsonProperty("occupations")
    private List<String> occupations;

    @JsonProperty("title")
    private String title;

    @JsonProperty("legat_names")
    private List<String> legatNames;

    @JsonProperty("age_max")
    private int ageMax;

    @JsonProperty("age_min")
    private int ageMin;

    @JsonProperty("additional_information")
    private String additionalInformation;

    @JsonProperty("race")
    private String race;

    @JsonProperty("reward_text")
    private String rewardText;

    @JsonProperty("ncic")
    private String ncic;

    @JsonProperty("languages")
    private List<String> languages;

    @JsonProperty("eyes_raw")
    private String eyesRaw;

    @JsonProperty("subjects")
    private List<String> subjects;

    @JsonProperty("possible_states")
    private List<String> possibleStates;

    @JsonProperty("place_of_birth")
    private String placeOfBirth;

    @JsonProperty("hair")
    private String hair;

    @JsonProperty("suspects")
    private List<String> suspects;

    @JsonProperty("weight_min")
    private int weightMin;

    @JsonProperty("@id")
    private String id;
}

package br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.FBI;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FBIWantedPerson {
    @JsonAlias({"@id", "id"})
    private String id;
    private String uid;
    private String title;
    private String description;
    private List<Image> images;
    private List<File> files;
    private String warning_message;
    private String remarks;
    private String details;
    private String additional_information;
    private String caution;
    private String reward_text;
    private int reward_min;
    private int reward_max;
    private List<String> dates_of_birth_used;
    private String place_of_birth;
    private List<String> locations;
    private List<String> field_offices;
    private List<String> legat_names;
    private String status;
    private String person_classification;
    private String poster_classification;
    private String ncic;
    private int age_min;
    private int age_max;
    private int weight_min;
    private int weight_max;
    private int height_min;
    private int height_max;
    private String eyes;
    private String hair;
    private String build;
    private String sex;
    private String race;
    private String nationality;
    private String scars_and_marks;
    private String complexion;
    private List<String> occupations;
    private List<String> possible_countries;
    private List<String> possible_states;
    private String modified;
    private String publication;
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getWarning_message() {
        return warning_message;
    }

    public void setWarning_message(String warning_message) {
        this.warning_message = warning_message;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getReward_text() {
        return reward_text;
    }

    public void setReward_text(String reward_text) {
        this.reward_text = reward_text;
    }

    public int getReward_min() {
        return reward_min;
    }

    public void setReward_min(int reward_min) {
        this.reward_min = reward_min;
    }

    public int getReward_max() {
        return reward_max;
    }

    public void setReward_max(int reward_max) {
        this.reward_max = reward_max;
    }

    public List<String> getDates_of_birth_used() {
        return dates_of_birth_used;
    }

    public void setDates_of_birth_used(List<String> dates_of_birth_used) {
        this.dates_of_birth_used = dates_of_birth_used;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getField_offices() {
        return field_offices;
    }

    public void setField_offices(List<String> field_offices) {
        this.field_offices = field_offices;
    }

    public List<String> getLegat_names() {
        return legat_names;
    }

    public void setLegat_names(List<String> legat_names) {
        this.legat_names = legat_names;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerson_classification() {
        return person_classification;
    }

    public void setPerson_classification(String person_classification) {
        this.person_classification = person_classification;
    }

    public String getPoster_classification() {
        return poster_classification;
    }

    public void setPoster_classification(String poster_classification) {
        this.poster_classification = poster_classification;
    }

    public String getNcic() {
        return ncic;
    }

    public void setNcic(String ncic) {
        this.ncic = ncic;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public int getAge_max() {
        return age_max;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public int getWeight_min() {
        return weight_min;
    }

    public void setWeight_min(int weight_min) {
        this.weight_min = weight_min;
    }

    public int getWeight_max() {
        return weight_max;
    }

    public void setWeight_max(int weight_max) {
        this.weight_max = weight_max;
    }

    public int getHeight_min() {
        return height_min;
    }

    public void setHeight_min(int height_min) {
        this.height_min = height_min;
    }

    public int getHeight_max() {
        return height_max;
    }

    public void setHeight_max(int height_max) {
        this.height_max = height_max;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getScars_and_marks() {
        return scars_and_marks;
    }

    public void setScars_and_marks(String scars_and_marks) {
        this.scars_and_marks = scars_and_marks;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public List<String> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<String> occupations) {
        this.occupations = occupations;
    }

    public List<String> getPossible_countries() {
        return possible_countries;
    }

    public void setPossible_countries(List<String> possible_countries) {
        this.possible_countries = possible_countries;
    }

    public List<String> getPossible_states() {
        return possible_states;
    }

    public void setPossible_states(List<String> possible_states) {
        this.possible_states = possible_states;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
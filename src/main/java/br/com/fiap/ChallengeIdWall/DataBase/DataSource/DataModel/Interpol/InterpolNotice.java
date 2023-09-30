package br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InterpolNotice {
    private List<ArrestWarrant> arrest_warrants;
    private int weight;
    private String forename;
    private String date_of_birth;
    private String entity_id;
    private List<String> languages_spoken_ids;
    private List<String> nationalities;
    private double height;
    private String sex_id;
    private String country_of_birth_id;
    private String name;
    private String distinguishing_marks;
    private List<String> eyes_colors_id;
    private List<String> hairs_id;
    private String place_of_birth;
    private Embedded _embedded;
    private Links _links;
    private String country;
    private String mother_name;
    private String mother_forename;
    private List<String> countries_likely_to_be_visited;
    private String issuing_country;
    private String place;
    private String date_of_event;
    private String father_forename;
    private String birth_name;
    private String father_name;

    public List<ArrestWarrant> getArrest_warrants() {
        return arrest_warrants;
    }

    public void setArrest_warrants(List<ArrestWarrant> arrest_warrants) {
        this.arrest_warrants = arrest_warrants;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public List<String> getLanguages_spoken_ids() {
        return languages_spoken_ids;
    }

    public void setLanguages_spoken_ids(List<String> languages_spoken_ids) {
        this.languages_spoken_ids = languages_spoken_ids;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<String> nationalities) {
        this.nationalities = nationalities;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSex_id() {
        return sex_id;
    }

    public void setSex_id(String sex_id) {
        this.sex_id = sex_id;
    }

    public String getCountry_of_birth_id() {
        return country_of_birth_id;
    }

    public void setCountry_of_birth_id(String country_of_birth_id) {
        this.country_of_birth_id = country_of_birth_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistinguishing_marks() {
        return distinguishing_marks;
    }

    public void setDistinguishing_marks(String distinguishing_marks) {
        this.distinguishing_marks = distinguishing_marks;
    }

    public List<String> getEyes_colors_id() {
        return eyes_colors_id;
    }

    public void setEyes_colors_id(List<String> eyes_colors_id) {
        this.eyes_colors_id = eyes_colors_id;
    }

    public List<String> getHairs_id() {
        return hairs_id;
    }

    public void setHairs_id(List<String> hairs_id) {
        this.hairs_id = hairs_id;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_forename() {
        return mother_forename;
    }

    public void setMother_forename(String mother_forename) {
        this.mother_forename = mother_forename;
    }

    public List<String> getCountries_likely_to_be_visited() {
        return countries_likely_to_be_visited;
    }

    public void setCountries_likely_to_be_visited(List<String> countries_likely_to_be_visited) {
        this.countries_likely_to_be_visited = countries_likely_to_be_visited;
    }

    public String getIssuing_country() {
        return issuing_country;
    }

    public void setIssuing_country(String issuing_country) {
        this.issuing_country = issuing_country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate_of_event() {
        return date_of_event;
    }

    public void setDate_of_event(String date_of_event) {
        this.date_of_event = date_of_event;
    }

    public String getFather_forename() {
        return father_forename;
    }

    public void setFather_forename(String father_forename) {
        this.father_forename = father_forename;
    }

    public String getBirth_name() {
        return birth_name;
    }

    public void setBirth_name(String birth_name) {
        this.birth_name = birth_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Embedded {
        private List<Links> links;

        public List<Links> getLinks() {
            return links;
        }

        public void setLinks(List<Links> links) {
            this.links = links;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links {
        private Self self;
        private Images images;
        private Thumbnail thumbnail;

        public Self getSelf() {
            return self;
        }

        public void setSelf(Self self) {
            this.self = self;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Self {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Images {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Thumbnail {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ArrestWarrant {
        private String issuing_country_id;
        private String charge;
        private String charge_translation;

        public String getIssuing_country_id() {
            return issuing_country_id;
        }

        public void setIssuing_country_id(String issuing_country_id) {
            this.issuing_country_id = issuing_country_id;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getCharge_translation() {
            return charge_translation;
        }

        public void setCharge_translation(String charge_translation) {
            this.charge_translation = charge_translation;
        }
    }
}

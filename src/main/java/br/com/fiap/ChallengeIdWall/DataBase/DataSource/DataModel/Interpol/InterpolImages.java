package br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InterpolImages {
    private Embedded _embedded;
    private Links _links;


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

    public static class Embedded {
        private List<Image> images;

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links {
        private Self self;
        private Notice notice;
        private Thumbnail thumbnail;

        public Self getSelf() {
            return self;
        }

        public void setSelf(Self self) {
            this.self = self;
        }

        public Notice getNotice() {
            return notice;
        }

        public void setNotice(Notice notice) {
            this.notice = notice;
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
    public static class Notice {
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
    public static class Image {
        private String picture_id;
        private ImageLinks _links;

        public String getPicture_id() {
            return picture_id;
        }

        public void setPicture_id(String picture_id) {
            this.picture_id = picture_id;
        }

        public ImageLinks get_links() {
            return _links;
        }

        public void set_links(ImageLinks _links) {
            this._links = _links;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ImageLinks {
        private Self self;

        public Self getSelf() {
            return self;
        }

        public void setSelf(Self self) {
            this.self = self;
        }
    }
}

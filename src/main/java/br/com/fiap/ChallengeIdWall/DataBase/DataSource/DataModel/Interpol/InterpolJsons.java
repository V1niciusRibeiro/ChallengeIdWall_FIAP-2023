package br.com.fiap.ChallengeIdWall.DataBase.DataSource.DataModel.Interpol;

public class InterpolJsons {

    private InterpolNotice interpolNotice;
    private InterpolImages interpolImages;

    public InterpolJsons() { }
    public InterpolJsons(InterpolNotice interpolNotice, InterpolImages interpolImages) {
        this.interpolNotice = interpolNotice;
        this.interpolImages = interpolImages;
    }

    public InterpolNotice getInterpolNotice() {
        return interpolNotice;
    }

    public void setInterpolNotice(InterpolNotice interpolNotice) {
        this.interpolNotice = interpolNotice;
    }

    public InterpolImages getInterpolImages() {
        return interpolImages;
    }

    public void setInterpolImages(InterpolImages interpolImages) {
        this.interpolImages = interpolImages;
    }
}

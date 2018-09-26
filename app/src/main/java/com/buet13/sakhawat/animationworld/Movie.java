package com.buet13.sakhawat.animationworld;

public class Movie {
    private String title;
    private String fulltitle;
    private String movie_year;
    private String categories;
    private String summary;
    private String image_URL;
    private String imdb_id;
    private String imdb_rating;
    private String runtime;
    private String language;
    private String ytid;

    Movie(){}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFulltitle(String fulltitle) {
        this.fulltitle = fulltitle;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public void setImdb_rating(String imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setMovie_year(String movie_year) {
        this.movie_year = movie_year;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setYtid(String ytid) {
        this.ytid = ytid;
    }

    public String getCategories() {
        return categories;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public String getImdb_rating() {
        return imdb_rating;
    }

    public String getLanguage() {
        return language;
    }

    public String getMovie_year() {
        return movie_year;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public String getYtid() {
        return ytid;
    }
}

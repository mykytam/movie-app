package com.example.movielover.models;

public class Movie {



    private String title;
    private String genre;
    private String year;
    private String runtime;
    private String description;
    private int thumbnail;
    private String studio;
    private String ratingImdb;
    private String ratingRotten;
    private String ratingMeta;
    private String trailerLink;
    private int coverPicture;





    public Movie(String title, String description, int thumbnail, String ratingImdb,String ratingRotten ,String ratingMeta,int coverPicture, String trailerLink, String genre, String year, String runtime) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.ratingImdb = ratingImdb;
        this.ratingRotten = ratingRotten;
        this.ratingMeta = ratingMeta;
        this.coverPicture = coverPicture;
        this.trailerLink = trailerLink;
        this.genre = genre;
        this.year = year;
        this.runtime = runtime;
    }

    public Movie(String title, String description, int thumbnail, String ratingImdb, int coverPicture) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.ratingImdb = ratingImdb;
        this.coverPicture = coverPicture;
    }

    public Movie(String title, int thumbnail, int coverPicture) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPicture = coverPicture;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;

    }
/*
    public Movie(String title, String description, int thumbnail, String studio, String ratingImdb, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.ratingImdb = ratingImdb;
        this.trailerLink = streamingLink;
    }
*/
    public String getRatingRotten() {
    return ratingRotten;
    }

    public void setRatingRotten(String ratingRotten) {
        this.ratingRotten = ratingRotten;
    }

    public String getRatingMeta() {
        return ratingMeta;
    }

    public void setRatingMeta(String ratingMeta) {
        this.ratingMeta = ratingMeta;
    }


    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getRuntime() { return runtime; }

    public void setRuntime(String runtime) { this.runtime = runtime; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(int coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRatingImdb() {
        return ratingImdb;
    }

    public void setRatingImdb(String ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String streamingLink) {
        this.trailerLink = trailerLink;
    }
}

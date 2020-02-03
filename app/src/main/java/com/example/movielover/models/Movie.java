package com.example.movielover.models;

public class Movie {



    private String title;
    private String genre;
    private int year;
    private String runtime;
    private String description;
    private int thumbnail;
    private String studio;
    private String rating;
    private String trailerLink;
    private int coverPicture;





    public Movie(String title, String description, int thumbnail, String rating, int coverPicture, String trailerLink, String genre, int year, String runtime) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.coverPicture = coverPicture;
        this.trailerLink = trailerLink;
        this.genre = genre;
        this.year = year;
        this.runtime = runtime;
    }

    public Movie(String title, String description, int thumbnail, String rating, int coverPicture) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.rating = rating;
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

    public Movie(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.trailerLink = streamingLink;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String streamingLink) {
        this.trailerLink = trailerLink;
    }
}

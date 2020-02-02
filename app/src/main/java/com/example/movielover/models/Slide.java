package com.example.movielover.models;

public class Slide {

    private int Image;
    private String Title;
    private String TrailerLink;

    public Slide(int image, String title, String trailerLink) {
        Image = image;
        Title = title;
        TrailerLink = trailerLink;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTrailerLink() {
        return TrailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        TrailerLink = trailerLink;
    }
}

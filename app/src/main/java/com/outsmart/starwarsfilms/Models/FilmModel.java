package com.outsmart.starwarsfilms.Models;

/**
 * Created by lucas on 21/09/17.
 */

public class FilmModel {

    private String id;
    private String title;
    private String image;
    private int episodeNumber;
    private int episodeYear;
    private double imdbRate;

    public FilmModel(String id, String title, String image, int episodeNumber, int episodeYear, double imdbRate) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.episodeNumber = episodeNumber;
        this.episodeYear = episodeYear;
        this.imdbRate = imdbRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeYear() {
        return episodeYear;
    }

    public void setEpisodeYear(int episodeYear) {
        this.episodeYear = episodeYear;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public void setImdbRate(double imdbRate) {
        this.imdbRate = imdbRate;
    }

}

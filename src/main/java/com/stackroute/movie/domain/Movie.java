package com.stackroute.movie.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private int movieId;
    private String original_title;
    private String overview;
    private String tagline;
    private double vote_average;
    public Movie() {
    }
    public Movie(int id, String original_title, String overview, String tagline, double vote_average) {
        this.movieId = id;
        this.original_title = original_title;
        this.overview = overview;
        this.tagline = tagline;
        this.vote_average = vote_average;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", tagline='" + tagline + '\'' +
                ", vote_average='" + vote_average + '\'' +
                '}';
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public double getVote_average() {
        return vote_average;
    }
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }
}

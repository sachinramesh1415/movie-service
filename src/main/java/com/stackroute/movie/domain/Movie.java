package com.stackroute.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private int movieId;
    private String original_title;
    private String overview;
    private String tagline;
    private double vote_average;

}

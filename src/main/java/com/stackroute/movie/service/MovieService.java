package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public void deleteMovie(int movieId);
    public void updateMovie(Movie movie);
    public List<Movie> findByName(String name) throws MovieNotFoundException;
}

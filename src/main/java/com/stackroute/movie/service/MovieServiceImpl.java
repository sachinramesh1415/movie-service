package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }
    @Override
    public void updateMovie(Movie movie) {
        movieRepository.deleteById(movie.getMovieId());
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }
}

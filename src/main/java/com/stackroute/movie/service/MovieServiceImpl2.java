package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("two")
public class MovieServiceImpl2 implements MovieService {

    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl2(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }
    @Override
    public List<Movie> getAllMovies() {
        return null;
    }
    @Override
    public void deleteMovie(int movieId) {

    }
    @Override
    public void updateMovie(Movie movie) {
    }

    @Override
    public List<Movie> findByName(String name) throws MovieNotFoundException {
        if(movieRepository.findByName(name).isEmpty())
        {
            throw new MovieNotFoundException("Movie Not Found");
        }
        return movieRepository.findByName(name);
    }
}

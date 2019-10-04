package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"one","default"})
public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieId()))
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if(savedMovie==null)
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
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
    public List<Movie> findByName(String name) throws MovieNotFoundException {
        return null;
    }
}

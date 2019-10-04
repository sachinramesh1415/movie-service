package com.stackroute.movie.controller;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    @Autowired
    private ConfigurableEnvironment env;
    @Autowired
    MovieService movieService;
    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        return new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }
    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            movieService.updateMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
        } catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable int movieId)
    {
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovie(movieId);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("movie/search={name}")
    public ResponseEntity<?> findByName(@PathVariable String name) throws MovieNotFoundException
    {
        return new ResponseEntity<List<Movie>>(movieService.findByName(name),HttpStatus.OK);
    }
}

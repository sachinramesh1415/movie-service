package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommanLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {
        movieRepository.save(new Movie(14,"Men in Black","fsdhfkjddfdsfsdfsdsfsdjfhsdjfsdfdf","MIB is back",7.8));

    }
}

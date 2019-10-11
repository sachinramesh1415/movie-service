package com.stackroute.movie.components;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private Environment env;
    @Value("${movieid}")
    private int id;
    @Value("${title}")
    private String title;
    @Value("${overview}")
    private String overview;
    @Value("${tagline}")
    private String tagline;
    @Value("${rating}")
    private double rating;
    @Override
    public void run(String... args) throws Exception {
       movieRepository.save(new Movie(id,title,overview,tagline,rating));
       movieRepository.save(new Movie(Integer.parseInt(env.getProperty("movieid3")),env.getProperty("title3"),env.getProperty("overview3"),env.getProperty("tagline3"),Double.parseDouble(env.getProperty("rating3"))));
    }
}

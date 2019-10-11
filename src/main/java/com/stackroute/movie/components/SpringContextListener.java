package com.stackroute.movie.components;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:movie.properties")
public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MovieRepository movieRepository;
    @Value("${movieid2}")
    private int id;
    @Value("${title2}")
    private String title;
    @Value("${overview2}")
    private String overview;
    @Value("${tagline2}")
    private String tagline;
    @Value("${rating2}")
    private double rating;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieRepository.save(new Movie(id,title,overview,tagline,rating));
    }
}

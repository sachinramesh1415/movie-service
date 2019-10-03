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
    int id;
    @Value("${title2}")
    String title;
    @Value("${overview2}")
    String overview;
    @Value("${tagline2}")
    String tagline;
    @Value("${rating2}")
    double rating;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieRepository.save(new Movie(id,title,overview,tagline,rating));
    }
}

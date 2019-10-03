package com.stackroute.movie.repository;

import com.stackroute.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("select c from Movie c where c.original_title = :chars")
    List<Movie> findByName(@Param("chars") String chars);
}

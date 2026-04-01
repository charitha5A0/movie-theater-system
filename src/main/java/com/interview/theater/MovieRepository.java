package com.interview.theater;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class MovieRepository {
    private final Map<String,Movie>  movies = new HashMap<>();

    public Optional<String> findByTitle(String title) {
        return movies.values().stream()
                .filter(m->m.getTitle().equalsIgnoreCase(title))
                .map(Movie::getId)
                .findFirst();
    }

    public Movie saveMovie(Movie movie){
        movies.put(movie.getId(),movie);
        log.info("List of Movies {}",movies);
        return movie;
    }

    public List<Movie> findall() {
        return movies.values().stream().toList();
    }
}

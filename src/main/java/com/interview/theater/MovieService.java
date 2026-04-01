package com.interview.theater;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie createMovie(MovieRequest movieRequest) {
        Optional<String> movieId = movieRepository.findByTitle(movieRequest.title);
        if (movieId.isPresent()) {
            log.error("Movie with title {} already exists", movieRequest.title);
            throw new ResponseStatusException(HttpStatus.CONFLICT, movieId.get());
        }
        else{
            log.info("Creating Movie with title {}", movieRequest.title);
            Movie movie = new Movie();
            movie.setTitle(movieRequest.title);
            movie.setGenre(movieRequest.genre);
            movie.setRating(movieRequest.rating);
            movie.setLangugae(movieRequest.langugae);
            movie.setDurationMinutes(movieRequest.durationMinutes);
            movie.setId("mov-"+ UUID.randomUUID());

            return movieRepository.saveMovie(movie);
        }
    }

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findall();
        if(movies.isEmpty()){
            log.error("No movies found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            log.info("Movies found");
            return movies;
        }
    }
}

package com.interview.theater;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest) {
            Movie movie = movieService.createMovie(movieRequest);
            log.info("Movie is created");
            return ResponseEntity.status(HttpStatus.CREATED).body(movie.getId());
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

}

package com.mukesh.movieservice.api;

import com.mukesh.movieservice.model.Movie;
import com.mukesh.movieservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        log.info("Return movie with id:{}",  id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> creteMovie(@RequestBody Movie movie) {
        Movie createMovie = movieService.createMovie(movie);
        log.info("create movie with id:{}",createMovie.getId());
        return ResponseEntity.ok(createMovie);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        log.info("Update movie with id:{}",id);
        movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        log.info("delete movie with id:{}", id);
        movieService.deleteMovie(id);
    }

}

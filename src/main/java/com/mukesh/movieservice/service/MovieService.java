package com.mukesh.movieservice.service;

import com.mukesh.movieservice.model.Movie;
import com.mukesh.movieservice.repo.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Movie movie){
        if(movie == null){
            throw new RuntimeException("Invalid Movie");
        }
        return movieRepository.save(movie);
    }
    public  Movie getMovieById(Long id){
        return  movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found this id"+ id));
    }

    public void updateMovie(Long id,Movie updateMovie){
        if(updateMovie == null || id ==null){
            throw new RuntimeException("Invalid Movie");
        }
        if(movieRepository.existsById(id)){
           Movie movie= movieRepository.getReferenceById(id);
           movie.setName(updateMovie.getName());
           movie.setDirector(updateMovie.getDirector());
           movie.setActors(updateMovie.getActors());
           movieRepository.save(movie);
        }else{
            throw new RuntimeException("Movie not found");
        }
    }

    public void deleteMovie(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        }else{
            throw new RuntimeException("Movie not found");
        }
    }


}

//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Component
//@Service
//public class MovieService {
//
//    @Autowired
//    MovieRepository movieRepository;
//    public String addMovie(Movie movie) {
//        return movieRepository.addMovie(movie);
//    }
//
//    public String addDirector(Director director) {
//        return movieRepository.addDirector(director);
//    }
//
//    public String addMovieDirectorPair(String movieName, String directorName) {
//        return movieRepository.addMovieDirectorPair(movieName,directorName);
//    }
//
//    public Movie getMovieByName(String name) {
//        return movieRepository.getMovieByName(name);
//    }
//
//    public Director getDirectorByName(String name) {
//        return movieRepository.getDirectorByName(name);
//    }
//
//    public List<String> getMoviesByDirectorName(String directorName) {
//        return movieRepository.getMoviesByDirectorName(directorName);
//    }
//
//    public List<String> findAllMovies() {
//        return movieRepository.fullAllMovies();
//    }
//
//    public String deleteDirectorByName(String directorName) {
//        return movieRepository.deleteDirectorByName(directorName);
//    }
//
//    public String deleteAllDirectors() {
//        return movieRepository.deleteAllDirectors();
//    }
//}
package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movie_name, String director_name){
        movieRepository.addMovieDirectorPair(movie_name, director_name);
    }
    public Movie getMovieByName(String movie_name){
        return movieRepository.getMovieByName(movie_name);
    }
    public Director getDirectorByName(String director_name){
        return movieRepository.getDirectorByName(director_name);
    }
    public List<String> getMoviesByDirectorName(String director_name){
        return movieRepository.getMoviesByDirectorName(director_name);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String director_name){
        movieRepository.deleteDirectorByName(director_name);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequestMapping("movies")
//@RestController
//public class MovieController {
//
//    @Autowired
//    MovieService movieService;
//
//    @PostMapping("/add-movie")
//    public ResponseEntity addMovie(@RequestBody Movie movie)
//    {
//        String response =movieService.addMovie(movie);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//    @PostMapping("/add-director")
//    public ResponseEntity addDirector(@RequestBody Director director)
//    {
//        String response =movieService.addDirector(director);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
//    @PutMapping("/add-movie-director-pair")
//    public ResponseEntity addMovieDirectorPair(@RequestParam("nameM") String nameM,@RequestParam("nameD") String nameD)
//    {
//        String response=movieService.addMovieDirectorPair(nameM,nameD);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
//    @GetMapping("/get-movie-by-name/{nameM}")
//    public ResponseEntity getMovieByName(@PathVariable("nameM") String nameM)
//    {
//        Movie movie = movieService.getMovieByName(nameM);
//        return new ResponseEntity<>(movie,HttpStatus.FOUND);
//    }
//    @GetMapping("/get-director-by-name/{nameD}")
//    public ResponseEntity getDirectorByName(@PathVariable("nameD") String nameD)
//    {
//        Director director = movieService.getDirectorByName(nameD);
//        return new ResponseEntity<>(director,HttpStatus.FOUND);
//    }
//
//    @GetMapping("/get-movies-by-director-name/{nameD}")
//    public ResponseEntity getMoviesByDirectorName(@PathVariable("nameD") String nameD)
//    {
//        List<String>ml=new ArrayList<>();
//
//        ml= movieService.getMoviesByDirectorName(nameD);
//        return new ResponseEntity<>(ml,HttpStatus.FOUND);
//    }
//
//    @GetMapping("/get-all-movies")
//    public ResponseEntity findAllMovies()
//    {
//        List<String>ml=new ArrayList<>();
//        ml=movieService.findAllMovies();
//        return new ResponseEntity(ml,HttpStatus.FOUND);
//    }
//
//    @DeleteMapping("/delete-director-by-name")
//    public ResponseEntity deleteDirectorByName(@RequestParam("nameD") String nameD)
//    {
//        String response=movieService.deleteDirectorByName(nameD);
//        return new ResponseEntity(response,HttpStatus.ACCEPTED);
//
//    }
//    @DeleteMapping("/delete-all-directors")
//    public ResponseEntity deleteAllDirectors()
//    {
//        String response=movieService.deleteAllDirectors();
//        return new ResponseEntity(response,HttpStatus.ACCEPTED);
//    }
//
//
//}
package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
//    	Use ResponseEntity object to return the required objects in the controllers

    @Autowired
    MovieService movieService;

    //    Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie
    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success message", HttpStatus.CREATED);
    }

    //    Add a director: POST /movies/add-director
//    Pass the Director object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addDirector
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success message", HttpStatus.CREATED);
    }

    //    Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieN") String movie_name,
                                               @RequestParam("directorN") String director_name){
        movieService.addMovieDirectorPair(movie_name, director_name);
        return new ResponseEntity<>("success message", HttpStatus.CREATED);
    }


    //    Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//    Pass movie name as path parameter
//    Return Movie object wrapped in a ResponseEntity object
//    Controller Name - getMovieByName
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movie_name){
        Movie movie = movieService.getMovieByName(movie_name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //    Get Director by director name: GET /movies/get-director-by-name/{name}
//    Pass director name as path parameter
//    Return Director object wrapped in a ResponseEntity object
//    Controller Name - getDirectorByName
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String director_name){
        Director director = movieService.getDirectorByName(director_name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    //    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//    Pass director name as path parameter
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - getMoviesByDirectorName
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director_name){
        List<String> list = movieService.getMoviesByDirectorName(director_name);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    //    Get List of all movies added: GET /movies/get-all-movies
//    No params or body required
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - findAllMovies
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    //    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
//    Pass director’s name as request parameter
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteDirectorByName
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("n") String director_name){
        movieService.deleteDirectorByName(director_name);
        return new ResponseEntity<>("success message", HttpStatus.CREATED);
    }

//    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
//    No params or body required
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteAllDirectors
//       (Note that there can be some movies on your watchlist that aren’t mapped to any of the director.
//             Make sure you do not remove them.)

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success message", HttpStatus.CREATED);
    }
}
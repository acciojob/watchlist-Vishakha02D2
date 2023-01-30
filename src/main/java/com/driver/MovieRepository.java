
package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    //CRUD operation

    Map<String, Movie> dbMovie = new HashMap<>(); // as we have no db so use for temporary purpose
    Map<String, Director> dbDirector = new HashMap<>();
    Map<String, List<String>> dbPair = new HashMap<>(); // director name + its movie list

    public void addMovie(Movie movie){
        String name = movie.getName();
        if(!dbMovie.containsKey(name))
            dbMovie.put(name, movie);
    }
    public void addDirector(Director director){
        String name = director.getName();
        if(!dbDirector.containsKey(name))
            dbDirector.put(name, director);
    }
    public void addMovieDirectorPair(String mName, String dName){
        if(dbMovie.containsKey(mName) && dbDirector.containsKey(dName)){
            List<String> temp = new ArrayList<>();
            if(dbPair.containsKey(dName)) //if director already in dbPair
                temp = dbPair.get(dName);
            temp.add(mName); // add movie to list

            dbPair.put(dName,temp); // put director and movie list in dbPair
        }
    }
    public Movie getMovieByName(String mName){
        return dbMovie.get(mName);
    }
    public Director getDirectorByName(String dName){
        return dbDirector.get(dName);
    }
    public List<String> getMoviesByDirectorName(String dName){
        return dbPair.get(dName);
    }
    public List<String> findAllMovies(){
        List<String> list = new ArrayList<>();
        for(String movie : dbMovie.keySet())
            list.add(movie);

        return list;
    }
    public void deleteDirectorByName(String dName){
        dbDirector.remove(dName); //remove from director db

        //checking the movies made by a director is added to movie or not
        List<String> movie = dbPair.get(dName);
        for(String m : movie) {
            dbMovie.remove(m);
        }

        dbPair.remove(dName); //remove from pair db
    }
    public void deleteAllDirectors(){
        dbDirector.clear();

        for(String director : dbPair.keySet()){
            List<String> movie = dbPair.get(director);
            for(String m : movie) {
                dbMovie.remove(m);
            }
        }

        dbPair.clear();
    }
}

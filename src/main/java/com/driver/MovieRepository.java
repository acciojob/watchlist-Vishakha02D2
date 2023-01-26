package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String,Movie> movieMap=new HashMap<>();
    Map<String,Director> directorMap=new HashMap<>();

    Map<String,List<String>> dirMovieMap=new HashMap<>();
    public String addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director) {
        directorMap.put(director.getName(),director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)){
            List<String> moviesList;
            if(!dirMovieMap.containsKey(directorName)) moviesList = new ArrayList<>();
            else {
                if (!dirMovieMap.get(directorName).contains(movieName)) moviesList = dirMovieMap.get(directorName);
                else return "Already contains Movie Director Pair";
            }
            moviesList.add(movieName);
            dirMovieMap.put(directorName,moviesList);
            return "Director Movie Pair Added";
        }
        return "Either MovieName or DirectorName not present";
    }

    public Movie getMovieByName(String name) {
        return movieMap.getOrDefault(name,null);
    }

    public Director getDirectorByName(String name) {
        return directorMap.getOrDefault(name,null);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        if(dirMovieMap.containsKey(directorName))
            return dirMovieMap.get(directorName);
        return new ArrayList<>();
    }

    public List<String> fullAllMovies() {
        List<String> listOfAllMovies=new ArrayList<>();
        for(String movieName:movieMap.keySet())
            listOfAllMovies.add(movieName);
        return listOfAllMovies;
    }


    public String deleteDirectorByName(String directorName) {
        if(dirMovieMap.containsKey(directorName)){
            for(String movieName:dirMovieMap.get(directorName)){
                if(movieMap.containsKey(movieName))movieMap.remove(movieName);
            }
            if(directorMap.containsKey(directorName)) directorMap.remove(directorName);
            dirMovieMap.remove(directorName);
            return "All the entries deleted by Director Name";
        }
        return "Director Name is not present";
    }

    public String deleteAllDirectors() {
        for(String directorName:directorMap.keySet()){
            if(dirMovieMap.containsKey(directorName)){
                for(String movieName:dirMovieMap.get(directorName)){
                    if(movieMap.containsKey(movieName)) movieMap.remove(movieName);
                }
                dirMovieMap.remove(directorName);
            }
            directorMap.remove(directorName);
        }
        return "All the directors entries are deleted";
    }
}
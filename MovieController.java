public class MovieController {
    @RestController
    public class MovieController {

        @Autowired
        MovieService movieController;

        @PostMapping("/add_movie")
        public ResponseEntity addMovie(@RequestParam("movie") Movie movie){
          Movie movie =  MovieService.addMovie(movie);
            return new ResponseEntity<>("New movie added successfuly", HttpStatus.CREATED);
        }
        @PostMapping("/add_director")
        public ResponseEntity addDirector(@RequestBody Director director){
            MovieService.addDirector(director);
            return new ResponseEntity<>("New Director added successfuly", HttpStatus.CREATED);
        }
        @PutMapping("/add-movie-director-pair")
        public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie ,@RequestParam("director")String director){
            MovieService.addMovieDirectorPair(movie,director);
            return new ResponseEntity<>("New Movie-Directr Pair updated successfuly", HttpStatus.CREATED);
        }
        @GetMapping("/get-movie-by-name/{name}")
        public ResponseEntity getMovieByName(@PathVariable String name){
            MovieService.getMovieByName(name);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }
        @GetMapping("/get-director-by-name/{name}")
        public ResponseEntity getDirectorByName(@PathVariable String name){
            MovieService.getDirectorByName(name);
            return new ResponseEntity<>(director, HttpStatus.CREATED);
        }
        @GetMapping("/get-movies-by-director-name/{director}")
        public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
            List<String> movies = movieService.findMoviesFromDirector(director);
            return new ResponseEntity<>(movies, HttpStatus.CREATED);
        }

        @GetMapping("/get-all-movies")
        public ResponseEntity<List<String>> findAllMovies(){
            List<String> movies = movieService.findAllMovies();
            return new ResponseEntity<>(movies, HttpStatus.CREATED);
        }

        @DeleteMapping("/delete-director-by-name")
        public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
            movieService.deleteDirector(director);
            return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
        }
        @DeleteMapping("/delete-all-directors")
        public ResponseEntity<String> deleteAllDirectors(){
            movieService.deleteAllDirectors();
            return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
        }
    }
}

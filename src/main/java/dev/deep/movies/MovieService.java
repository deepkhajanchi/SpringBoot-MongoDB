package dev.deep.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/*
* In this class, write db access methods
* */
@Service
public class MovieService {
    /*
    Inside this class, we need a reference to the repository
    Autowired will let framework know that we want framework to
    instantiate this class here for us.
    */
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    /*
    - findById method may not find any movie at all, id we passed
    may not exist. In this case, it needs to return null.
    - Use Optional in this case. So that we can return null.
    * */
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}

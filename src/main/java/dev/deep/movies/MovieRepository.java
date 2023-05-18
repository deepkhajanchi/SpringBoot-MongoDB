package dev.deep.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
MongoRepository- Generic Type
- Need to mention that what kind of data we are passing in.
*/
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    /*
    - we don't want to expose ObjectId to public.
    So, we can implement method to search movie by imdbId.
    * */
    Optional<Movie> findMovieByImdbId(String imdbId);
}

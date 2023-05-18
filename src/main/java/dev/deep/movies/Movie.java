package dev.deep.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/*
* - Movie class represents each document in movies collection
* - Instead of getters and setters and constructors, use @Data from lombok
* It takes care of all getter-setter and toString methods.
* - AllArgsConstructor, basically an annotation for creating constructor that takes all this private field
* as argument
* - NoArgsConstructor- doesn't take any parameter
* - DocumentReference- DB will only store the IDs of the review and reviews will be in
* separate collection-Manual reference relationship
* */

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
}

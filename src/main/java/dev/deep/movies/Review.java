package dev.deep.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
* - Spring Application has an ability to create a new collection by mentioning in annotation.
* - Instead of getters and setters and constructors, use @Data from lombok
* It takes care of all getter-setter and toString methods.
* - AllArgsConstructor, basically an annotation for creating constructor that takes all this private field
* as argument
* - NoArgsConstructor- doesn't take any parameter
* */

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;

    public Review(String body){
        this.body=body;
    }
}

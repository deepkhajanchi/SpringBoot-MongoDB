package dev.deep.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* In this class, write db access methods
* */
@Service
public class ReviewService {
    /*
    Inside this class, we need a reference to the repository
    Autowired will let framework know that we want framework to
    instantiate this class here for us.
    */
    @Autowired
    private ReviewRepository reviewRepository;

    //associate reviews with existed movies
    /*
    - Along with Repositories, we also can use template to talk to database
    * There are times when repository is not viable because of complex operations that cannot be
    * implemented within a repository or if implementable, not suitable.
    - We can use this template to form up a new dynamic query and
    do the job inside the db without using the repository.
    * */
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){

        /*
        We can just save the review on insert because when we call insert,
        it actually returns the data we just pushed inside the db.
        * */
        Review review= reviewRepository.insert(new Review(reviewBody));

        /*Using the template to perform an update call on the movie class
        "update" does the job of making the change inside the db.
        So update.push(reviewIds). So we want to update the review Ids
        in the found movie and the value of this movie will be "review".
        - So the review that we have just created it will be pushed inside
        the reviewIds array.
        * */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}

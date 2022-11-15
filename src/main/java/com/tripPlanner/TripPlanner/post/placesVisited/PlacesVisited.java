package com.tripPlanner.TripPlanner.post.placesVisited;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tripPlanner.TripPlanner.post.posts.Post;
import com.tripPlanner.TripPlanner.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PlacesVisited {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull(message = "post id cannot be null")
    @JsonProperty
    private Post postId;
    @NotNull(message = "place name cannot be null")
    @JsonProperty
    private String placeName;
    @JsonProperty
    private float rating;
    @JsonProperty
    @Column(length = 65555)
    private String about;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
////    @NotNull(message = "user id cannot be null")
//    @JsonProperty
//    private User userId;

    public PlacesVisited() {
    }

    public PlacesVisited(Post postId, String placeName, float rating, String about) {
        this.postId = postId;
        this.placeName = placeName;
        this.rating = rating;
        this.about = about;
//        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = new Post(postId);
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

//    public User getUserId() {
//        return userId;
//    }
//
//    public void setUserId(User userId) {
//        this.userId = userId;
//    }
}

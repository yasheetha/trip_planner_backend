package com.tripPlanner.TripPlanner.post.placesVisited;

import com.tripPlanner.TripPlanner.post.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacesVisitedRepository extends JpaRepository<PlacesVisited,Integer> {
    List<PlacesVisited> findByPostId(Post postId);
    //@Query("SELECT postId FROM PlacesVisited WHERE place_name=:name")
    //@Query("SELECT postId FROM PlacesVisited WHERE place_name LIKE CONCAT('%',?1,'%') ")
    //@Query("SELECT postId FROM PlacesVisited WHERE place_name LIKE '%'||:name||'%' ")
    @Query("SELECT postId FROM PlacesVisited WHERE place_name LIKE %:name% ")

    List<Post> findPostIdByPlaceName(@Param("name") String name);

    List<Post> findPostIdByPlaceNameContaining(String name);
    //getPostIdByPlaceNameContainingIgnoreCase
}

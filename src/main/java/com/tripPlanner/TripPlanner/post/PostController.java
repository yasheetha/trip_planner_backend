package com.tripPlanner.TripPlanner.post;

import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisited;
import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisitedRepository;
import com.tripPlanner.TripPlanner.post.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PlacesVisitedRepository placesVisitedRepository;

    @PostMapping("/savePost")
    public String savePost(@Valid @RequestBody PostRequest postRequest){
        return postService.savePost(postRequest);
    }
    @PostMapping("/savePost1")
    public String savePost(@Valid @RequestBody PlacesVisited placesVisited){
        placesVisitedRepository.save(placesVisited);
        return "done";
    }

    @GetMapping("/posts")
    public Set<PostResponse> get(){
        for(PostResponse pr : postService.getPosts("")){
            System.out.println(pr.getPostId()+" "+pr.getDate()+" "+pr.getEstimatedCost()+" "+pr.getLocationName()+" "+pr.getLikes()+" "+pr.getPlacesVisited());
        }
        return postService.getPosts("");
    }

    @GetMapping("/getPosts/{locationName}")
    public Set<PostResponse> getPosts(@PathVariable String locationName){
        return postService.getPosts(locationName);
    }
}

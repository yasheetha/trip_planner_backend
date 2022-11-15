package com.tripPlanner.TripPlanner.post;

import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisited;
import com.tripPlanner.TripPlanner.post.placesVisited.PlacesVisitedRepository;
import com.tripPlanner.TripPlanner.post.posts.Post;
import com.tripPlanner.TripPlanner.post.posts.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PlacesVisitedRepository placesVisitedRepository;

    public String savePost(PostRequest postRequest){
        Post post = new Post(postRequest.getUser(), postRequest.getLocationName(), postRequest.getExperience(), postRequest.getEstimatedCost(), postRequest.getDate());
        postRepository.save(post);
        for(int i=0; i<postRequest.getPlacesVisited().size();i++){
            PlacesVisited place = postRequest.getPlacesVisited().get(i);
            PlacesVisited placeVisited = new PlacesVisited(post, place.getPlaceName(), place.getRating(), place.getAbout());
            placesVisitedRepository.save(placeVisited);
        }
        return "post saved successfully";
    }

    public Set<PostResponse> getPosts(String locationName){
        Set<PostResponse> response = new HashSet<>();
        List<Post> posts;
        List<Post> postsFromPlacesVisited;
        Set<PlacesVisited> pv = new HashSet<>();
        if(locationName==""){
            posts = postRepository.findAll();
        }
        else {
            posts = postRepository.getByLocationName(locationName);
        }
        //Set<Post> posts = new HashSet<Post>(posts1);
        for(Post post : posts){
            List<PlacesVisited> placesVisited = placesVisitedRepository.findByPostId(post);
            pv.addAll(placesVisited);
            List<PlacesVisitedResponse> placesVisitedResponse = new ArrayList<>();
            for(int j=0; j<placesVisited.size();j++){
                    PlacesVisited placeVisited = placesVisited.get(j);
                    placesVisitedResponse.add(new PlacesVisitedResponse(placeVisited.getPlaceName(),placeVisited.getRating(),placeVisited.getAbout()));
            }
            response.add(new PostResponse(post.getId(),post.getUser().getUsername(),post.getLocationName(),post.getExperience(),post.getEstimatedCost(),post.getLikes(),post.getDate(),placesVisitedResponse));
        }
        //System.out.println(response);
        if(locationName!="") {
            System.out.println("=======");
            postsFromPlacesVisited = placesVisitedRepository.findPostIdByPlaceName(locationName);
            for (Post post : postsFromPlacesVisited) {
                System.out.println("=======|||||");
                List<PlacesVisited> placesVisited = placesVisitedRepository.findByPostId(post);
                List<PlacesVisitedResponse> placesVisitedResponse = new ArrayList<>();
                for (int j = 0; j < placesVisited.size(); j++) {
                    System.out.println("======={{{{{{{");
                    PlacesVisited placeVisited = placesVisited.get(j);
                    placesVisitedResponse.add(new PlacesVisitedResponse(placeVisited.getPlaceName(), placeVisited.getRating(), placeVisited.getAbout()));
                }
                System.out.println(post.getId()+" "+post.getUser().getUsername()+" "+post.getLocationName()+" "+post.getExperience()+" "+post.getEstimatedCost()+" "+post.getLikes()+" "+post.getDate()+" "+placesVisitedResponse);
                response.add(new PostResponse(post.getId(), post.getUser().getUsername(), post.getLocationName(), post.getExperience(), post.getEstimatedCost(), post.getLikes(), post.getDate(), placesVisitedResponse));
            }
        }
        //System.out.println(response);
        Set<String> s = new HashSet<>();
        s.add("hi");
        s.add("h");
        s.add("h");
        s.add("hi");
        s.add("hii");
        //System.out.println(s);
        return response;
    }
}

package com.careerdevs.placeholderV1.controllers;

import com.careerdevs.placeholderV1.models.Photos;
import com.careerdevs.placeholderV1.models.Users;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class JSONController {

    //This class holds the methods that pull info with the mappings

    @GetMapping("/users/all") //GET all user data
    public Users[] allUsers(RestTemplate restTemplate) {
        String URL = "https://jsonplaceholder.typicode.com/users/";
        return restTemplate.getForObject(URL, Users[].class);
    }

    @GetMapping ("/users/{ID}") //GET one user by ID
    public Object getUser (RestTemplate restTemplate, @PathVariable(name = "ID") String id ){
        String URL = "https://jsonplaceholder.typicode.com/users/" + id;

        try {

            return restTemplate.getForObject(URL, Users.class);

        } catch (HttpClientErrorException.NotFound e) {

            return "User not found";

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping ("/users") //Get all users within a range of IDs
    public Object selectUsers (RestTemplate restTemplate, @RequestParam(name = "start") Integer start,
                               @RequestParam(name = "end") Integer end){
        ArrayList<Users> allUsers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            String URL = "https://jsonplaceholder.typicode.com/users/" + i;
            Users onlyOne = restTemplate.getForObject(URL, Users.class);
            Collections.addAll(allUsers, onlyOne);
        }

        return allUsers;
    }

    // All the routes for the photos

    @GetMapping("/photos/all") //GET all photo data
    public Photos[] getPhotos(RestTemplate restTemplate) {
        String URL = "https://jsonplaceholder.typicode.com/photos/";
        return restTemplate.getForObject(URL, Photos[].class);
    }

    @GetMapping("/photos/{ID}") //GET one photo by ID
    public Object photoById(RestTemplate restTemplate, @PathVariable(name = "ID") String id) {
        String URL = "https://jsonplaceholder.typicode.com/photos/" + id;

        try {

            return restTemplate.getForObject(URL, Photos.class);

        } catch (HttpClientErrorException.NotFound e) {

            return "Page not found";

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/photos") //Get all photos within a range of IDs
    public Object selectPhotos(RestTemplate restTemplate, @RequestParam(name = "start") Integer start,
                               @RequestParam(name = "end") Integer end) {
        ArrayList<Photos> allPhotos = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            String URL = "https://jsonplaceholder.typicode.com/photos/" + i;
            Photos single = restTemplate.getForObject(URL, Photos.class);
            Collections.addAll(allPhotos, single);
        }

        return allPhotos;
    }

}

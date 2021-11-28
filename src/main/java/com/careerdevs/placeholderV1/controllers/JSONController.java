package com.careerdevs.placeholderV1.controllers;

import com.careerdevs.placeholderV1.models.Photos;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class JSONController {

    //This class holds the methods that pull info with the mappings

    /*@GetMapping ("/users") //GET all user data
    public String allUsers (){
        return String;
    }

    @GetMapping ("/users/{ID}") //GET one user by ID
    public String getUser (){
        return String;
    }

    @GetMapping ("/") //Get all users within a range of IDs
    public String selectUsers (){
        return String;
    }*/

    // All the routes for the photos

    @GetMapping ("/photos/all") //GET all photo data
    public Photos[] getPhotos (RestTemplate restTemplate){
        String URL = "https://jsonplaceholder.typicode.com/photos/";
        return restTemplate.getForObject(URL, Photos[].class);
    }

    @GetMapping ("/photos/{ID}") //GET one photo by ID
    public Object photoById (RestTemplate restTemplate, @PathVariable(name = "ID") String id){
        String URL = "https://jsonplaceholder.typicode.com/photos/" + id;

        try {

            return restTemplate.getForObject(URL, Photos.class);

        } catch (HttpClientErrorException.NotFound e){

            return "Page not found";

        } catch (Exception e){

            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping ("/photos") //Get all photos within a range of IDs
    public Object selectPhotos (RestTemplate restTemplate, @RequestParam(name = "start") Integer start,
                                                           @RequestParam(name = "end") Integer end){
        ArrayList<Photos> allPhotos = new ArrayList<>();

        for (int i = start; i <= end ; i++) {
            String URL = "https://jsonplaceholder.typicode.com/photos/" + i;
            Photos single = restTemplate.getForObject(URL, Photos.class);
            Collections.addAll(allPhotos, single);
        }

        return allPhotos;
    }

}

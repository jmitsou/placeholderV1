package com.careerdevs.placeholderV1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HolderController {

    //This class holds the methods that pull info with the mappings

    @GetMapping ("/users") //GET all user data
    public String allUsers (){
        return String;
    }

    @GetMapping ("/users/[ID]") //GET one user by ID
    public String getUser (){
        return String;
    }

    @GetMapping ("/photos") //GET all photo data
    public String getPhotos (){
        return String;
    }

    @GetMapping ("/photos/[ID]") //GET one photo by ID
    public String allUsers (){
        return String;
    }

    @GetMapping ("/") //Get all users within a range of IDs
    public String selectUsers (){
        return String;
    }

    @GetMapping ("/") //Get all photos within a range of IDs
    public String selectPhotos (){
        return String;
    }

}

package com.aziru.restworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.Profile;
import com.aziru.restworld.service.ProfileService;

@RestController
@RequestMapping("/users/{userId}/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    ResponseEntity<Profile> create(@PathVariable("userId") final Integer userId, final Profile profile) {
	return new ResponseEntity<Profile>(profileService.save(userId, profile), HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    ResponseEntity<Profile> getById(@PathVariable("userId") final Integer userId,
	    @PathVariable("profileId") final Integer profileId) {
	return new ResponseEntity<Profile>(profileService.findByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
    }

}

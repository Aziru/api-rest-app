package com.aziru.restworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.Address;
import com.aziru.restworld.service.AddressService;

@RestController
@RequestMapping("users/{userId}/profiles/{profileId}/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAddressByProfileAndUserId(@PathVariable("userId") final Integer userId,
	    @PathVariable("profileId") final Integer profileId) {
	return new ResponseEntity<List<Address>>(addressService.findAddressByUserAndProfile(userId, profileId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> create(@PathVariable("userId") final Integer userId, @PathVariable("profileId") final Integer profileId,
	    @RequestBody final Address address) {
	return new ResponseEntity<Address>(addressService.create(userId, profileId, address), HttpStatus.OK);
    }

}

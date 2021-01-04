package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.Address;
import com.aziru.restworld.repository.AddressRepository;
import com.aziru.restworld.repository.ProfileRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Address> findAddressByUserAndProfile(final Integer userId, final Integer profileId) {
	return addressRepository.findAddressByUserAndProfile(userId, profileId);
    }

    public Address create(final Integer userId, final Integer profileId, final Address address) {
	final var profile = profileRepository.findByUserIdAndProfileId(userId, profileId);
	if (profile.isPresent()) {
	    address.setProfile(profile.get());
	    return addressRepository.save(address);
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
		    String.format("Profile %d not and user $d not found", profileId, userId));
	}
    }
}

package com.aziru.restworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.Profile;
import com.aziru.restworld.repository.ProfileRepository;
import com.aziru.restworld.repository.UserRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRespository;

    @Autowired
    private UserRepository userRepository;

    public Profile save(final Integer userId, final Profile profile) {
	final var user = userRepository.findById(userId);
	if (user.isPresent()) {
	    profile.setUser(user.get());
	    return profileRespository.save(profile);
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User $d not found", userId));
	}
    }

    public Profile findByUserIdAndProfileId(final Integer userId, final Integer profileId) {
	return profileRespository.findByUserIdAndProfileId(userId, profileId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
			String.format("Profile not found for user %d and profile %d not found", userId, profileId)));
    }

}

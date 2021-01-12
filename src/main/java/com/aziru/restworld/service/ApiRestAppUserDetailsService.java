package com.aziru.restworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.repository.UserInRoleRepository;
import com.aziru.restworld.repository.UserRepository;

@Service
public class ApiRestAppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInRoleRepository userInRoleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	final var userOptional = userRepository.findByUserName(username);
	if (userOptional.isPresent()) {
	    final var user = userOptional.get();
	    final var rolesByUser = userInRoleRepository.findByUser(user.getId());
	    final var roles = rolesByUser.stream().map(Role::getName).toArray(String[]::new);
	    return org.springframework.security.core.userdetails.User.withUsername(user.getUserName()).password(encoder.encode(user.getPassword())).roles(roles)
		    .build();
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User $s not found", username));
	}
    }

}

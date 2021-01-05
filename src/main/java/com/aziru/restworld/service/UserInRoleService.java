package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.UserInRole;
import com.aziru.restworld.repository.RoleRepository;
import com.aziru.restworld.repository.UserInRoleRepository;
import com.aziru.restworld.repository.UserRepository;

@Service
public class UserInRoleService {

    @Autowired
    private UserInRoleRepository userInRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<UserInRole> findUserInRolebyUserId(final Integer userId) {
	return userInRoleRepository.findUserInRoleByUserId(userId);
    }

    public UserInRole create(final Integer userId, final Integer roleId) {
	final var user = userRepository.findById(userId);
	if (user.isPresent()) {
	    final var userInRole = new UserInRole();
	    userInRole.setUser(user.get());
	    final var role = roleRepository.findById(roleId);
	    if (role.isPresent()) {
		userInRole.setRole(role.get());
		return userInRoleRepository.save(userInRole);
	    } else {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role %d not found", roleId));
	    }
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId));
	}
    }

}

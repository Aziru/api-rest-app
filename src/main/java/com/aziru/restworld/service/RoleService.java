package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
	return roleRepository.findAll();
    }

    public Role createRole(final Role role) {
	return roleRepository.save(role);
    }

    public Role updateRole(final Integer id, final Role role) {
	final var roleToUpdate = roleRepository.findById(id);
	if (roleToUpdate.isPresent()) {
	    return roleRepository.save(role);
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %s doesnt exist", id));
	}
    }

    public void deleteRole(final Integer id) {
	final var roleToDelete = roleRepository.findById(id);
	if (roleToDelete.isPresent()) {
	    roleRepository.deleteById(id);
	} else {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %s doesnt exist", id));
	}
    }
}

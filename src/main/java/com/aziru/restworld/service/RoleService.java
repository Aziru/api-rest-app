package com.aziru.restworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.models.AuditDetails;
import com.aziru.restworld.models.MyAppRestSecurityRule;
import com.aziru.restworld.repository.RoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@MyAppRestSecurityRule
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public List<Role> getRoles() {
	return roleRepository.findAll();
    }

    public Role createRole(final Role role) {
	final var roleCreated = roleRepository.save(role);
	final var userName = SecurityContextHolder.getContext().getAuthentication().getName();
	final var mapper = new ObjectMapper();
	try {
	    kafkaTemplate.send("api-rest-app-topic", mapper.writeValueAsString(new AuditDetails(userName, roleCreated.getName())));
	} catch (final JsonProcessingException e) {
	    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error parsing message");
	}
	return roleCreated;
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

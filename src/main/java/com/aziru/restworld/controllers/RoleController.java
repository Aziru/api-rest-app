package com.aziru.restworld.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.entity.User;
import com.aziru.restworld.entity.UserInRole;
import com.aziru.restworld.service.RoleService;
import com.aziru.restworld.service.UserInRoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserInRoleService userInRoleService;

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
	final var authentication = SecurityContextHolder.getContext().getAuthentication();

	log.info("Name {}", authentication.getName());
	log.info("Principal {}", authentication.getPrincipal());
	log.info("Credentials {}", authentication.getCredentials());
	log.info("Roles {}", authentication.getAuthorities().toString());

	return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/{roleName}/users")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable("roleName") final String roleName) {
	return new ResponseEntity<List<User>>(userInRoleService.getUsersbyRoleName(roleName), HttpStatus.OK);
    }

    @PostMapping("/{roleId}/user/{userId}")
    public ResponseEntity<UserInRole> create(@PathVariable("userId") final Integer userId, @PathVariable("roleId") final Integer roleId) {
	return new ResponseEntity<UserInRole>(userInRoleService.create(userId, roleId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody final Role role) {
	return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable(name = "roleId") final Integer id, @RequestBody final Role role) {
	return new ResponseEntity<>(roleService.updateRole(id, role), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable(name = "roleId") final Integer id) {
	roleService.deleteRole(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

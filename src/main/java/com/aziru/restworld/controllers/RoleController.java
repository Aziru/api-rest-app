package com.aziru.restworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.Role;
import com.aziru.restworld.service.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
	return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody final Role role) {
	return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable(name = "roleId") final Integer id,
	    @RequestBody final Role role) {
	return new ResponseEntity<>(roleService.updateRole(id, role), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable(name = "roleId") final Integer id) {
	roleService.deleteRole(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

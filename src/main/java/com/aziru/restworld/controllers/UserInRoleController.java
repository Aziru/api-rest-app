package com.aziru.restworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.UserInRole;
import com.aziru.restworld.service.UserInRoleService;

@RestController
@RequestMapping("/users/{userId}/roles")
public class UserInRoleController {

    @Autowired
    private UserInRoleService userInRoleService;

    @GetMapping
    public ResponseEntity<List<UserInRole>> getRolesByUserId(@PathVariable("userId") final Integer userId) {
	return new ResponseEntity<List<UserInRole>>(userInRoleService.findUserInRolebyUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/{roleId}")
    public ResponseEntity<UserInRole> create(@PathVariable("userId") final Integer userId, @PathVariable("roleId") final Integer roleId) {
	return new ResponseEntity<UserInRole>(userInRoleService.create(userId, roleId), HttpStatus.OK);
    }

}

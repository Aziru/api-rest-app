package com.aziru.restworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aziru.restworld.entity.User;
import com.aziru.restworld.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Page<User>> getUsers(
			@RequestParam(value = "page", required = false, defaultValue = "0") final int page,
			@RequestParam(value = "size", required = false, defaultValue = "100") final int size) {
		return new ResponseEntity<>(userService.getUsers(page, size), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "userId") final Integer userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	@RequestMapping("/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") final String username) {
		return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<User> authenticate(@RequestBody final User user) {
		return new ResponseEntity<>(userService.getUserByUserNameAndPassword(user), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody final User user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") final Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

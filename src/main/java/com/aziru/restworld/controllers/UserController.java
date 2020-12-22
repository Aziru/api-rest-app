package com.aziru.restworld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping // Method HTTP + resource: handler method
	public ResponseEntity<List<User>> getUsers(
			@RequestParam(value = "startWith", required = false) final String startWith) {
		return new ResponseEntity<>(userService.getUsers(startWith), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "userId") final Integer userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	@RequestMapping("/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") final String username) {
		return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
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

//	@GetMapping // Method HTTP + resource: handler method
//	public ResponseEntity<List<User>> getUsers(
//			@RequestParam(value = "startWith", required = false) final String startWith) {
//		return new ResponseEntity<>(userService.getUsers(startWith), HttpStatus.OK);
//	}
//

//	@PutMapping(value = "/{username}")
//	public ResponseEntity<User> updateUser(@PathVariable("username") final String username,
//			@RequestBody final User user) {
//		return new ResponseEntity<>(userService.updateUser(username, user), HttpStatus.OK);
//	}
//

}

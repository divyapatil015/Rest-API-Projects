package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.express.entities.User;
import com.express.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
    
	//json
	@PostMapping
	public void createUser(@RequestBody User user) {
		log.info("UserController::createUser{} ",user.getEmail());
		userService.createUser(user);
	}
	
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Long userId) {
		log.info("UserController:: getUserById {} ",userId);
		return userService.findUserById(userId);
	}
	@GetMapping("username/{userId}")
	public void fetchUserInformationByUsername(@PathVariable Long userId) {
		log.info("UserController:: getUserById {} ",userId);
		//return userService.findUserById(userId);
	}
	
	@PutMapping("{userId}")
	public void updateUser(@PathVariable Long userId, @RequestBody User user) {
		userService.updateUser(userId, user);
	}
	
	@DeleteMapping("{userId}")
	public void deleteuser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	
}

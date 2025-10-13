package com.dell.cloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dell.cloud.dto.UserDTO;
import com.dell.cloud.entity.User;
import com.dell.cloud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
    
	//private OrderClient orderClient;

	// Register new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
		User user = userService.registerUser(userDTO);
		return ResponseEntity.ok(user);
	}

	// Authenticate new user without JWT
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
		Optional<User> user = userService.findByUserName(userDTO.getUsername());
		if (user.isPresent()) {
			return ResponseEntity.ok("Login Successfull");
		}
		return ResponseEntity.status(401).body("Invalid Credentials");
	}

	
	 /*public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) { 
		 orderClient.getOrdersByUserId(id);
	  return ResponseEntity.ok(userService.findById(id)); 
	  }*/
	 

	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {		
		return ResponseEntity.ok(userService.findById(id));

	}

}

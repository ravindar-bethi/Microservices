package com.dell.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.cloud.service.UserService;

@RestController
@RequestMapping("/config")
public class ConfigController {

	private final UserService userService;

	@Autowired
	public ConfigController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/show")
	public void showConfig() {
		userService.printConfiguration();
	}

}

package com.yash.mavendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mavendemo.model.User;
import com.yash.mavendemo.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	 private UserService userService;
	 
	@PostMapping("/add")
	 public void addUser(@RequestBody User user) {
		 userService.addUser(user);
	 }
	
	@GetMapping("/test")
	public void test() {
		System.out.println("test");
	}

}

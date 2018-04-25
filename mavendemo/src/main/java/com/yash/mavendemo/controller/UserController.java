package com.yash.mavendemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/list")
	@ResponseBody
	public List<User> listUsers() {
		return userService.listUsers();
	}

	@PutMapping("/update")
	public boolean updateUser(@RequestBody User user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable String id) {
		return userService.delete(Integer.parseInt(id));
	}
}

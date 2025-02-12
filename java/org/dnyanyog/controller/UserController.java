package org.dnyanyog.controller;

import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService UserService;
	
	@PostMapping (path ="/add",produces = {"application/json","application/xml"} ,consumes ={"application/json","application/xml"})
	public UserResponse AddUser(@RequestBody UserRequest user) {
		return UserService.addUser(user);
	}

	@GetMapping (path ="/display",produces = {"application/json","application/xml"} ,consumes ={"application/json","application/xml"})
	public UserResponse getUser() {
		return UserService.getAllUser();
	}
}

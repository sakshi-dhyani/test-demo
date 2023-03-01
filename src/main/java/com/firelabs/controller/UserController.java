package com.firelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firelabs.dto.Response;
import com.firelabs.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("signup")
	public ResponseEntity<Response> signup(@RequestParam (value ="firstName" , required=true )String firstName,
			@RequestParam (value ="lastName" , required=false )String lastName,
			@RequestParam (value ="email" , required=true )String email,
			@RequestParam (value ="password" , required=true )String password
			
			){
		
		return userService.signup(firstName,lastName,email,password);
	}
}

package com.firelabs.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firelabs.dto.Response;
import com.firelabs.entity.User;
import com.firelabs.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	Response response = new Response();

	public ResponseEntity<Response> signup(String firstName, String lastName, String email, String password) {
		
		User findEmail = userRepository.findByEmail(email);
		if(findEmail!=null) {
			response.setCode(409);
			response.setError(HttpStatus.CONFLICT.name());
			response.setMessage("email allready registered");
			response.setResult(null);
			return new ResponseEntity<Response>(response,HttpStatus.CONFLICT);
			
		}
		
		if(firstName ==null || firstName.isEmpty()) {
			response.setCode(400);
			response.setError(HttpStatus.BAD_REQUEST.name());
			response.setMessage("enter first name");
			response.setResult(null);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		if(lastName ==null || lastName.isEmpty()) {
			response.setCode(400);
			response.setError(HttpStatus.BAD_REQUEST.name());
			response.setMessage("enter last name");
			response.setResult(null);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		if(email ==null || email.isEmpty()) {
			response.setCode(400);
			response.setError(HttpStatus.BAD_REQUEST.name());
			response.setMessage("enter email ");
			response.setResult(null);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		if(password ==null || password.isEmpty()) {
			response.setCode(400);
			response.setError(HttpStatus.BAD_REQUEST.name());
			response.setMessage("enter first name");
			response.setResult(null);
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		if (!email.contains("@")) {
			response.setMessage("Invalid email address");
			response.setCode(400);
			response.setError(HttpStatus.BAD_REQUEST.name());
			response.setResult(null);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		
		//email check
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email.trim());
		if (matcher.matches() != true) {
			
			response.setCode(400);
			response.setResult(null);
			response.setMessage("Invalid Email!");
			response.setResult(null);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		
		User user =new User();
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setCreationTime(System.currentTimeMillis());
		userRepository.save(user); 
		
		

		
		
		response.setCode(200);
		response.setError(null);
		response.setMessage("success");
		response.setResult(null);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}

}

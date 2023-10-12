package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Services.UserServices;
import com.app.daos.UserDao;
import com.app.entities.User;
import com.app.model.ResponseDTO;

@RestController //@Controller + @ResponseBody
@CrossOrigin //React connection
@RequestMapping("/login") // use when we have more than one controller 
public class LoginRegisterController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserServices userservice;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		System.out.println("In register User"+user);
		try{
			if(userDao.findByEmail(user.getEmail()) == null) {
				
					User usersaved=userservice.registerUser(user);
					usersaved.setPassword("**");
					if(usersaved != null) {
						ResponseDTO response= new ResponseDTO("successfully Registered");
					return  ResponseEntity.ok(response);
						//return ResponseEntity.status(HttpStatus.OK).body(response);
					}
					else
						throw new Exception();
			}else {
				ResponseDTO response= new ResponseDTO("email already exist");
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
				//return  new ResponseEntity<>("email", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch (Exception e) {
			ResponseDTO response= new ResponseDTO("something went wrong");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			//return new ResponseEntity<>("error",
					//HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getUserDetails(@RequestBody User user) {
		System.out.println("in get user dtls " + user.getEmail()+user.getPassword());
	try{
			User userauth=userservice.auth(user.getEmail(), user.getPassword());
			System.out.println("user"+userauth);
			if(userauth==null) {
				ResponseDTO response= new ResponseDTO("please insert valid Email and Password");
				return new ResponseEntity<>(response,
						HttpStatus.NOT_FOUND);
				//return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else {
				userauth.setPassword("***");
				//session.setAttribute("user", userauth);
				//return  ResponseEntity.ok(userauth);}
				
				ResponseDTO response= new ResponseDTO("success",userauth);
			return  ResponseEntity.ok(response);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			ResponseDTO response= new ResponseDTO("something went wrong");
			return new ResponseEntity<>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

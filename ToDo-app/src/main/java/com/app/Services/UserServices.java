package com.app.Services;

import org.springframework.stereotype.Service;

import com.app.entities.User;
@Service 
public interface UserServices {
	User registerUser(User user);
	
	User auth(String Email, String password);

}

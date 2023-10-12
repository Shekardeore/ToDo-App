package com.app.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.UserDao;
import com.app.entities.User;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDao userdao;
	
	PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(User user) {
		//System.out.println("Chandrashekhar " +user);
		passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User userSaved= userdao.save(user);
		return userSaved;
	}

	@Override
	public User auth(String Email, String password) {
		
			//System.out.println("Chandrashekhar");
			User user = userdao.findByEmail(Email);
			System.out.println("user ===="+user);
			passwordEncoder= new BCryptPasswordEncoder();
			if(user != null && passwordEncoder.matches(password,user.getPassword())) {
				//System.out.println(user);
				return user;
			}
			return null;
	}

}

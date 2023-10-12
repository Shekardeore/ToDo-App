package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	// User findByEmail(String Email);

	 //User findByUserId(int parseInt);

	 User findByEmail(String email);

}

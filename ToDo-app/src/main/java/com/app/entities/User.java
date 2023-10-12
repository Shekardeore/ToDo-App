package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="User")
public class User {//implements UserDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	@Column(name="UserId",unique=true)
	private int UserId;
	
	/*@Column(name="username",unique=true)
	private String Username; */
	
	@Column(name="Email", unique=true)
	private String email;
	
	@Column(name="password")
	private String Password;
	
	public User() {
		super();
		
	}
	
	public User(int userId, String eMail, String password) {
		super();
		UserId = userId;
		email = eMail;
		Password = password;
	}


	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String eMail) {
		email = eMail;
	}

   // @Override
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


	@Override
	public String toString() {
		return "User [UserId=" + UserId + ",  email=" + email + ", Password=" + Password
				+ "]";
	}

	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		 List<GrantedAuthority> roles= new ArrayList<>();
		 roles.add(new Authority("Role_user"));
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	*/
	
	
	

}

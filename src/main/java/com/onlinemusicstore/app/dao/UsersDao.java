package com.onlinemusicstore.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.onlinemusicstore.app.models.Customer;
import com.onlinemusicstore.app.models.User;
import com.onlinemusicstore.app.repository.UserRepositry;

@Repository
public class UsersDao {
	
	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	
	public void saveUser(User getuser) {
		//User user  = new User();
		System.out.println("the user  saved");
		userRepositry.save(getuser);	
	}
	
	public User getUserByEmail(String email) {
		User getUser = userRepositry.findByEmail(email);
		System.out.println("the customer iss " + getUser.getEmail());
		return getUser;
	}
	
//	public void saveing() {
//		User user  = new User();
//		user.setFirstName("user");
//		System.out.println("user are saved1");
//		user.setLastName("user2");
//		System.out.println("user are saved2");
//		user.setEmail("user@gmail.com");
//		System.out.println("user are saved3");
//		user.setPassword(passEncoder.encode("user"));
//		System.out.println("user are saved4");
//		user.setUsername("userlogin");
//		user.setVerified(true);
//		userRepositry.save(user);
//		System.out.println("user are saved");
//	}

}

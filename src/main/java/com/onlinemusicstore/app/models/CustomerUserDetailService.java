package com.onlinemusicstore.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinemusicstore.app.repository.UserRepositry;

@Service
public class CustomerUserDetailService implements UserDetailsService{
	
	@Autowired
	
	private UserRepositry userRepositry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepositry.findByUsername(username);
		
		
		if(user==null) {
			throw new UsernameNotFoundException("No user present with username: "+username);
		}
		else
			return new CustomerUserDetails(user);
	}
	 


}

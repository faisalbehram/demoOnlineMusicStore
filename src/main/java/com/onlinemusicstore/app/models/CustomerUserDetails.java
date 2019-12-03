package com.onlinemusicstore.app.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerUserDetails  implements UserDetails{
	

	private static final long serialVersionUID = 1L;
	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		

		return user.getRoles();
	}

	public CustomerUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public String getPassword() {
		//System.out.println("the password iss" + user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		//System.out.println("the username iss" + user.getUsername());

		return user.getEmail();
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
		return user.isVerified();
	}

}

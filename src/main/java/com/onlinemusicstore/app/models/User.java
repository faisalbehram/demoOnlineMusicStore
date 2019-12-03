package com.onlinemusicstore.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User  extends AbstractEntity {

	
	@NotNull(message = "email should be given")
	@Pattern(regexp = "^(.+)@(.+)$",message = "email is not in valid form")
	private String email;
	
	@NotNull(message = "Password Must be given")
	private String password;
	
	private boolean verified;
	
	@NotNull(message = "is Required")
	@Size(min = 1 , message = "this is required")
	private String  username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isVerified() {
		return verified;
	}
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name= "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User() {
		
	}
	
	public User(User user) {


		this.email = user.getEmail();

		this.password = user.getPassword();

		this.roles = user.getRoles();
		
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
	
}	

	
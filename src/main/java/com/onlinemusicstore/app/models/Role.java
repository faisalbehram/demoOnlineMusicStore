package com.onlinemusicstore.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;




@Entity
public class Role extends AbstractEntity  implements GrantedAuthority{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@ManyToMany(mappedBy = "roles" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<User> users =  new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	@Override
	public String getAuthority() {
		return name;
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role() {
		
	}
	
	
}

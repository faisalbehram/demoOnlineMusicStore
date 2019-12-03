package com.onlinemusicstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinemusicstore.app.models.User;


public interface UserRepositry extends JpaRepository<User, Long> {

	//Users findByEmail(String email);
	User findByUsername(String username);

	User findByEmail(String email);

}

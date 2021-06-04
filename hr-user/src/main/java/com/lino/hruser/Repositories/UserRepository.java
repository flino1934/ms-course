package com.lino.hruser.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lino.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);//esta utilizando query Methods

}

package com.lino.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.hroauth.entities.User;
import com.lino.hroauth.feignclients.UserFeignclients;


@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignclients userFeignclients;
	
	public User findByEmail(String email) {//Vai buscar o usuario por email pelo micro serviços de usuarios 
		
		User user = userFeignclients.findByEmail(email).getBody();//vai buscar pela interface
		if (user == null) {
	
			logger.error("Email not found "+email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found " +email);
		return user;
	}
	
}

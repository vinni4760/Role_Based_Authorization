package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.User;
import com.rest.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository repo;

	@Override
	public void saveuser(User user) {
             repo.save(user);		
	}

}

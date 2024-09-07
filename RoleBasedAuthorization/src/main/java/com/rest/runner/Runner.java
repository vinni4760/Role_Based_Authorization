package com.rest.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rest.entity.User;
import com.rest.service.IUserService;

//@Component
public class Runner  implements CommandLineRunner{

	@Autowired
	private IUserService userservice;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(101);
		user.setName("vinay");
		user.setEnroll("0828ADMIN01");
		user.setEmail("vinaytanwar696@gmail.com");
		user.setMobileNo(7879212856l);
		user.setRole("ADMIN");
		user.setPassword(encoder.encode("1234"));
//		userservice.saveuser(user);
	}

}

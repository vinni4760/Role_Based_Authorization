package com.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.entity.User;
import com.rest.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserRepository userepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  User user = 	userepo.findByEnroll(username);
		 System.out.println("username\s:"+username);
			System.out.println("user\s:"+user);
			 if (user == null) {
		         throw new UsernameNotFoundException("User not found");
			 }
			
			 return  new CustomUserDetails(user);
			
		}

}

package com.rest.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.entity.User;
import com.rest.repository.IUserRepository;
import com.rest.service.IUserService;

@Controller
public class IndexController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IUserRepository userepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/home")
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/home/register")
	public String showregister(Map<String, Object> map) {
		map.put("user", new User());
		return "register";
	}
	
	@PostMapping("/home/saveUser")
	public String register(@ModelAttribute("user")User user) {
         System.out.println(user);
         user.setRole("ROLE_ADMIN");
         user.setPassword(encoder.encode(user.getPassword()));
         service.saveuser(user);
		return "registrationsuccess";
	}
	
	

}

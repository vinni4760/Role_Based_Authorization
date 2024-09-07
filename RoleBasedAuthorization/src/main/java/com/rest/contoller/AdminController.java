package com.rest.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/profile")
	public String adminpage() {
		return "admin";
	}

}

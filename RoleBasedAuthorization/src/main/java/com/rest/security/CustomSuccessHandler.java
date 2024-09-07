package com.rest.security;

import java.io.IOException;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(roles);
		
		  if (roles.contains("ROLE_ADMIN")) {
				System.out.println("admin");
				response.sendRedirect("/admin/profile");
				
			} else {
				System.out.println("user");
				response.sendRedirect("/user/profile");
			}
		
	}

}

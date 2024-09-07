package com.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rest.entity.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomSuccessHandler successhandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.
		csrf(csrf->csrf.disable())
		.authorizeHttpRequests(request->request.
				requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				 .requestMatchers("/home/**").permitAll()
				 .anyRequest()
				 .authenticated()
			
				)
		.formLogin(form->form.
				loginPage("/login")
				.usernameParameter("enroll")
				.passwordParameter("password")
				.successHandler(successhandler)
				.failureUrl("/login?error")
				.permitAll());
		
		
		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService());
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	@Bean
	public User user() {
		return new User();
	}
	
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}

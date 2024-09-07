package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	 public User findByEnroll(String username);
}

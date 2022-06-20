package com.example.cvproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cvproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUserNameAndPassword(String userName, String password);
	


}

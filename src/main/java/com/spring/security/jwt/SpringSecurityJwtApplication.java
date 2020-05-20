package com.spring.security.jwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.security.jwt.entity.User;
import com.spring.security.jwt.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"java","java","java@gmail.com"),
				new User(102,"dhanu","dhanu","dhanu@gmail.com"),
				new User(103,"sai","sai","sai@gmail.com"),
				new User(104,"chinna","chinna","chinna@gmail.com")
				).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}

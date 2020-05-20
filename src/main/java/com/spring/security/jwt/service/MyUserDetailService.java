package com.spring.security.jwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.jwt.entity.User;
import com.spring.security.jwt.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//Optional<User> user = repository.loadUserByUsername(userName);
		Optional<User> user = repository.findByUserName(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found user : "+userName));
		
		return user.map(MyUserDetails::new).get();
	}

}

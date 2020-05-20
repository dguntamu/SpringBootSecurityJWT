package com.spring.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jwt.entity.AuthRequest;
import com.spring.security.jwt.util.JwtUtil;

@RestController
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome JWT Home</h1>");
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassWord()));
		} catch (Exception e) {
			throw new Exception("Invalid User Name or Pass word");
		}

		return jwtUtil.generateToken(authRequest.getUserName());
	}
}

package com.dell.cloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dell.cloud.config.OrderServiceConfig;
import com.dell.cloud.dto.UserDTO;
import com.dell.cloud.entity.User;
import com.dell.cloud.respository.UserRepository;

@Service
public class UserService {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${server.port}")
	private String serverPort;

	/*
	 * @Autowired private OrderServiceConfig orderServiceConfig;
	 */

	@Value("${order.service.url}")
	private String orderServiceUrl;

	@Value("${spring.datasource.url}")
	private String databaseUrl;

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public void printConfiguration() {
		System.out.println("Jwt secret:" + jwtSecret);
		System.out.println("User service-server port number:" + serverPort);
		System.out.println("Order-service-URL:" + orderServiceUrl);
		System.out.println("Database url:" + databaseUrl);
		// System.out.println("Order Service Url:"+orderServiceConfig.getUrl());
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}

	public User registerUser(UserDTO userDTO) {
		User user = User.builder().username(userDTO.getUsername()).email(userDTO.getEmail())
				.password(bCryptPasswordEncoder.encode(userDTO.getPassword())).build();
		return userRepository.save(user);

	}

	public Optional<User> findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
}

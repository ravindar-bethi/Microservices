package com.dell.cloud.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dell.cloud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
  Optional<User> findByUserName(String username);

}

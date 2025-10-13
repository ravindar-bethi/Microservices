package com.dell.cloud.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
  Optional<User> findByUsername(String username);

}

package com.code.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.blog.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}

package com.hcl.booklib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.booklib.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserNameAndPassword(String userName, String password);
}

package com.infy.fos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.fos.entity.User;

import org.springframework.stereotype.Repository;

import com.infy.fos.entity.User;

@Repository


public interface UserRepository extends CrudRepository<User, String>{
	//public User findByEmailIdAndPassword(String emailId,String password);
	 Optional<User> findByEmailId( String emailId);
	 Optional<User> findByMobileNo(String mobileNo);

}

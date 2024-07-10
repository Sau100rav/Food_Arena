package com.infy.fos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.infy.fos.entity.User;
import com.infy.fos.exception.FoodException;
import com.infy.fos.repository.UserRepository;

import com.infy.fos.dto.UserDTO;
import com.infy.fos.dto.UserDetails;


@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public String signUp(UserDTO userdto) throws FoodException {
		Optional<User> optional=userRepository.findByEmailId(userdto.getEmailId());
		Optional<User> op=userRepository.findByMobileNo(userdto.getMobileNo());
		if(optional.isPresent())
		{
			throw new FoodException("UserService.USER_ALREADY_EXISTS");

	    }
		else if(op.isPresent())
		{
			throw new FoodException("UserService.USER_WITH_THIS_MOBILE_NO_ALREADY_PRESENT");
		}
		else if(!(userdto.getPassword().equals(userdto.getConfirmPassword())))
		{
			throw new FoodException("UserService.PASSWORD_NOT_MATCH");
		}




		User userEntity = new User();

		userEntity.setEmailId(userdto.getEmailId());
		userEntity.setName(userdto.getName());
		userEntity.setPassword(userdto.getPassword());
		userEntity.setConfirmPassword(userdto.getConfirmPassword());
		userEntity.setMobileNo(userdto.getMobileNo());
		User userEntity2 =userRepository.save(userEntity);
		return userEntity2.getEmailId();

	}




 

	@Override
	public User UserLogIn(String emailId, String password) throws FoodException {

		Optional<User> optional=userRepository.findByEmailId(emailId);
		   if(!optional.isPresent())
		     {
				throw new FoodException("UserService.INVALID_EMAILID");
		      }
		   else
		      {
			   User user=optional.get();
				if(user.getPassword().equals(password))
			     {
				   return user;
			     }

			     else
			        {
				   throw new FoodException("UserService.INVALID_PASSWORD");
			        }
		      }

	}


 

	@Override
	public UserDetails getUsers(String emailId) throws FoodException {

		Optional<User> op=userRepository.findByEmailId(emailId);
		//User user=op.orElseThrow(()->new FoodException("UserService.USER_NOT_FOUND"));
		if(op.isPresent()) 
		{
			User u=op.get();
	        return new UserDetails(u.getEmailId(),u.getName(),u.getMobileNo());

		}

		else
		{
			throw new FoodException("UserService.USER_NOT_FOUND");
		}


	}

 

	@Override
	public List<UserDTO> getAllUsers() throws FoodException {

		Iterable<User> users=userRepository.findAll();
		List<UserDTO> user2=new ArrayList<>();
		users.forEach(user->{
			UserDTO dto=new UserDTO();
			dto.setEmailId(user.getEmailId());
			dto.setName(user.getName());
			dto.setPassword(user.getPassword());
			dto.setConfirmPassword(user.getConfirmPassword());
			dto.setMobileNo(user.getMobileNo());
			user2.add(dto);

		});
		if(user2.isEmpty())

			throw new FoodException("UserService.USER_NOT_FOUND");

		return user2;
	}

 

}


package com.infy.fos.service;
import java.util.List;
import com.infy.fos.dto.UserDTO;
import com.infy.fos.entity.User;
import com.infy.fos.exception.FoodException;
import com.infy.fos.dto.UserDetails;

public interface UserService  {
	public String signUp(UserDTO userdto) throws FoodException;
	public User UserLogIn(String emailId,String password) throws FoodException;
	//public User VendorLogin(String emailId,String password)throws FoodException;
	public UserDetails getUsers(String emailId) throws FoodException;
	public List<UserDTO> getAllUsers() throws FoodException;
}

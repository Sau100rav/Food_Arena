package com.infy.fos.api;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.fos.dto.UserDTO;
import com.infy.fos.dto.UserDetails;
import com.infy.fos.dto.VendorDTO;
import com.infy.fos.entity.User;
import com.infy.fos.exception.FoodException;
import com.infy.fos.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Validated
@CrossOrigin
public class UserAPI {
	
	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;

	@PostMapping(value = "/register") //http://localhost:8021/users/register
	public ResponseEntity<String> addUser( @Valid @RequestBody UserDTO userdto) throws FoodException {

		String emailId = userService.signUp(userdto);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + emailId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

 

}
	@PostMapping (value = "/Userlogin")//http://localhost:8221/users/Userlogin
	public ResponseEntity<String> Userlogin(@RequestBody Map<String, String> credentials) throws FoodException{
		String emailId=credentials.get("emailId");
		String password=credentials.get("password");

		User user=userService.UserLogIn(emailId,password);
		 if(user !=null)
		 {


			 String successMessage = environment.getProperty("API.LOGIN_SUCCESS") +emailId;
			 return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		     }

		    else
		    {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Check your password or category ");
	        }
		}

 

	

	@GetMapping(value = "/getdetails/{emailId}")//http://localhost:8221/users/getdetails/emailid
	public ResponseEntity<UserDetails> getUsers(@PathVariable String emailId) throws FoodException{
		UserDetails u=userService.getUsers(emailId);
		if(u!=null)
		{
			return  ResponseEntity.ok(u);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping(value = "/allusers") //http://localhost:8221/users/allusers
	public ResponseEntity<List<UserDTO>> getAllUsers() throws FoodException{
		List<UserDTO> userList=userService.getAllUsers();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
}

	/*

 

http://localhost:8221/users/register
{
     "mobileNo": "9471239314",
      "confirmPassword":"Sona@123",
       "emailId":"monaai@123gmail.com",
        "name":"Sonali Singh",
         "password": "Sona@123" ,


 

}

 

*/

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.fos.dto.VendorDTO;
import com.infy.fos.dto.VendorDetails;
import com.infy.fos.entity.Vendor;
import com.infy.fos.exception.FoodException;
import com.infy.fos.service.VendorService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(value="/vendor-api")
@CrossOrigin
public class VendorAPI {
	@Autowired

	private VendorService vendorService;

	@Autowired

	private Environment environment;

 

	@PostMapping(value = "/register") //http://localhost:8021/vendor-api/register

	public ResponseEntity<String> addVendor( @Valid @RequestBody VendorDTO vendordto) throws FoodException {

 

		String emailId = vendorService.signUp(vendordto);

		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + emailId;

		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

 

	}

 

	@GetMapping(value="/getvendors")//http://localhost:8021/vendors/getvendors

	public ResponseEntity<List<VendorDTO>> getAllVendors() throws FoodException

	{

		List<VendorDTO> list = vendorService.getAllVendors();

		return new ResponseEntity<>(list,HttpStatus.OK);

	}

 

	@PostMapping (value = "/Vendorlogin")//http://localhost:9090/vendor-api/Vendorlogin

	public ResponseEntity<String> Vendorlogin(@RequestBody Map<String, String> credentials) throws FoodException{

		String emailId=credentials.get("emailId");

		String password=credentials.get("password");

 

		Vendor vendor=vendorService.VendorLogin(emailId,password);

		 if(vendor !=null)

		 {

			 String successMessage = environment.getProperty("API.VENDOR_LOGIN_SUCCESSFULL") +emailId;

			 return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

		     }

 

		    else

		    {

 

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Check your password ");

 

	        }
		 

		}	

	@GetMapping(value = "/getdetails/{emailId}")//http://localhost:9090/vendor-api/getdetails//emailid
	public ResponseEntity<VendorDetails> getVendors(@PathVariable String emailId) throws FoodException{
		VendorDetails v=vendorService.getDetails(emailId);
		if(v!=null)
		{
			return  ResponseEntity.ok(v);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}

	}

 

 

 

}

 

 

 

 

 

//"vendorName":"Tms",

//"emailId":"tmms@123gmail.com",

//"mobileNumber":"9071239314",

//"image":"../assets/foodimages/pasta.png",

//"description":"A Destination of Taste & Purity",

// "password": "Tmss@123",

// "confirmPassword":"Tmss@123"

//


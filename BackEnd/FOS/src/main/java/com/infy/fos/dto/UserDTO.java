package com.infy.fos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotNull(message = "{user.email.notpresent}")
	@Email(message = "{user.email.invalid}")
	private String emailId;

	@NotEmpty(message = "{user.name.notpresent}")
	@Pattern(regexp = "[A-Z][a-z]+(\\s[A-z][a-z]+)*",message = "{user.name.invalid}")
	private String name;

	@NotEmpty(message ="{user.password.notpresent}" )
	@Pattern(regexp = "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$",message ="{user.password.invalid}" )
	private String password;

	@NotEmpty(message = "{user.confirmpassword.notpresent}" )
	//@Pattern(regexp = "(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$)",message ="{user.confirmpassword.invalid}" )

 

	private String confirmPassword;



	//@NotEmpty(message = "{user.mobileNo.notpresent}")
	//@Size(max = 10 ,message ="{user.mobileNo.notpresent}" )
	@Pattern(regexp = "[6-9][0-9]{9}" ,message = "{user.mobileNo.invalid}")
	private String mobileNo;





	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


 

	public UserDTO(String emailId, String name, String mobileNo) {
	   super();
		this.emailId = emailId;
		this.name = name;
		this.mobileNo = mobileNo;
	}

 

 

	public UserDTO(String emailId, String name, String password, String confirmPassword, String mobileNo) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobileNo = mobileNo;

	}

 

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

 

	public String getName() {
		return name;
	}

 

	public void setName(String name) {
		this.name = name;
	}

 

	public String getPassword() {
		return password;
	}

 

	public void setPassword(String password) {
		this.password = password;
	}

 

	public String getConfirmPassword() {
		return confirmPassword;
	}

 

   public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

 

	
     public String getMobileNo() {
		return mobileNo;
	}

 

 

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

 

 

    @Override
	public String toString() {
		return "UserDTO [emailId=" + emailId + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword +  ", mobileNo=" + mobileNo + "]";
	}


}
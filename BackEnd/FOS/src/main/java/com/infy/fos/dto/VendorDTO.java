package com.infy.fos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class VendorDTO {
	private Integer vendorId;

	@NotEmpty(message = "{vendor.name.notpresent}")

	//@Pattern(regexp = "[A-Z][a-z]+(\\s[A-z][a-z]+)*",message = "{vendor.name.invalid}")

	private String vendorName;

 

	@NotNull(message = "{vendor.email.notpresent}")

	@Email(message = "{vendor.email.invalid}")

	private String emailId;

 

	//@Size(max = 10 ,message ="{vendor.mobileNo.notpresent}" )

	@Pattern(regexp = "[6-9][0-9]{9}" ,message = "{vendor.mobileNo.invalid}")

	private String mobileNumber;

 

	private String image;

 

	private String description;

 

	@NotEmpty(message ="{vendor.password.notpresent}" )

	@Pattern(regexp = "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$",message ="{vendor.password.invalid}" )

    private String password;

    private String confirmPassword;

 

	public Integer getVendorId() {

		return vendorId;

	}

	public void setVendorId(Integer vendorId) {

		this.vendorId = vendorId;

    }

	public String getVendorName() {

		return vendorName;

	}

	public void setVendorName(String vendorName) {

		this.vendorName = vendorName;

	}

	public String getEmailId() {

		return emailId;

	}

	public void setEmailId(String emailId) {

		this.emailId = emailId;

	}

	public String getMobileNumber() {

		return mobileNumber;

	}

	public void setMobileNumber(String mobileNumber) {

		this.mobileNumber = mobileNumber;

	}

	public String getImage() {

		return image;

	}

	public void setImage(String image) {

		this.image = image;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

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

 

	public VendorDTO() {

		super();

		// TODO Auto-generated constructor stub

	}

	public VendorDTO(Integer vendorId, String vendorName, String emailId, String mobileNumber, String image,

			String description, String password, String confirmPassword) {

		super();

		this.vendorId = vendorId;

		this.vendorName = vendorName;

		this.emailId = emailId;

		this.mobileNumber = mobileNumber;

		this.image = image;

		this.description = description;

		this.password = password;

		this.confirmPassword = confirmPassword;

	}

	@Override

	public String toString() {

		return "VendorDTO [vendorId=" + vendorId + ", vendorName=" + vendorName + ", emailId=" + emailId

				+ ", mobileNumber=" + mobileNumber + ", image=" + image + ", description=" + description + ", password="

				+ password + ", confirmPassword=" + confirmPassword + "]";

	}

 

 

//	public VendorDTO(String vendorName, String emailId, String phoneNumber, String image, String description,

//			String password, String confirmPassword) {

//		super();

//		this.vendorName = vendorName;

//		this.emailId = emailId;

//		this.phoneNumber = phoneNumber;

//		this.image = image;

//		this.description = description;

//		this.password = password;

//		this.confirmPassword = confirmPassword;

//	}

//	@Override

//	public String toString() {

//		return "VendorDTO [vendorName=" + vendorName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber

//				+ ", image=" + image + ", description=" + description + ", password=" + password + ", confirmPassword="

//				+ confirmPassword + "]";

//	}

 

 

 

	

 

}	
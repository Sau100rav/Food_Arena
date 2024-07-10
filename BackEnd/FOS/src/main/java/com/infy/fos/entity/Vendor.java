package com.infy.fos.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EK_VENDOR")
public class Vendor {
	@Id

	 

	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer vendorId;

 

	private String vendorName;

 

	private String emailId;

 

	private String mobileNumber;

 

	private String image;

 

	private String description;

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

 

//	public Vendor(String vendorName, String emailId, String phoneNumber, String image, String description,

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

 

	public Vendor() {

		super();

		// TODO Auto-generated constructor stub

	}

	public Vendor(Integer vendorId, String vendorName, String emailId, String mobileNumber, String image, String description,

		String password, String confirmPassword) {

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

	public int hashCode() {

		return Objects.hash(confirmPassword, description, emailId, image, password, mobileNumber, vendorId, vendorName);

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Vendor other = (Vendor) obj;

		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(description, other.description)

&& Objects.equals(emailId, other.emailId) && Objects.equals(image, other.image)

&& Objects.equals(password, other.password) && Objects.equals(mobileNumber, other.mobileNumber)

&& Objects.equals(vendorId, other.vendorId) && Objects.equals(vendorName, other.vendorName);

	}

	@Override

	public String toString() {

		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", emailId=" + emailId + ", mobileNumber="

				+ mobileNumber + ", image=" + image + ", description=" + description + ", password=" + password

				+ ", confirmPassword=" + confirmPassword + "]";

	}

 

}

//	@Override

//	public String toString() {

//		return "Vendor [vendorName=" + vendorName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", image="

//				+ image + ", description=" + description + ", password=" + password + ", confirmPassword="

//				+ confirmPassword + "]";

//	}

//	@Override

//	public int hashCode() {

//		return Objects.hash(confirmPassword, description, emailId, image, password, phoneNumber, vendorName);

//	}

//	@Override

//	public boolean equals(Object obj) {

//		if (this == obj)

//			return true;

//		if (obj == null)

//			return false;

//		if (getClass() != obj.getClass())

//			return false;

//		Vendor other = (Vendor) obj;

//		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(description, other.description)

//				&& Objects.equals(emailId, other.emailId) && Objects.equals(image, other.image)

//				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)

//				&& Objects.equals(vendorName, other.vendorName);

//	}
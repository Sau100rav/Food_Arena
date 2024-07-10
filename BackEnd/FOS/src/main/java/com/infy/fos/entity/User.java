package com.infy.fos.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EK_CUSTOMER")
public class User {
	
	@Id
	private String emailId;
	private String name;
	 private String password; 
	 private String confirmPassword;


	 @Column(name="phone_number", length = 255) 
	 private String mobileNo;

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
		return "User [emailId=" + emailId + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", mobileNo=" + mobileNo + "]";
	}

 

	@Override
	public int hashCode() {
		return Objects.hash(confirmPassword, emailId, mobileNo, name, password);
	}

 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(emailId, other.emailId)
&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(name, other.name)
&& Objects.equals(password, other.password);
	}
	}
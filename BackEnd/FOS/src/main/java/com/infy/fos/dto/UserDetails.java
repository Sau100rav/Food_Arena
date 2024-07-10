package com.infy.fos.dto;

public class UserDetails {
	private String emailId;
	private String name;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public UserDetails(String emailId, String name, String mobileNo) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	
	
}

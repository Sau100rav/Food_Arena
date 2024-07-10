package com.infy.fos.dto;

public class VendorDetails {
	 private Integer vendorId;
		private String vendorName;
		private String emailId;
		private String mobileNumber;
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
		public VendorDetails(Integer vendorId, String vendorName, String emailId, String mobileNumber) {
			super();
			this.vendorId = vendorId;
			this.vendorName = vendorName;
			this.emailId = emailId;
			this.mobileNumber = mobileNumber;
		}

		}
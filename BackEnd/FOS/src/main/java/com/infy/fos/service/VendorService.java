package com.infy.fos.service;

import java.util.List;

import com.infy.fos.dto.VendorDTO;
import com.infy.fos.dto.VendorDetails;
import com.infy.fos.entity.Vendor;
import com.infy.fos.exception.FoodException;

import jakarta.validation.Valid;

public interface VendorService {
	public String signUp(VendorDTO vendorDTO) throws FoodException;

	public Vendor VendorLogin(String emailId,String password)throws FoodException;

	 public List<VendorDTO> getAllVendors();
	 public VendorDetails getDetails(String emailId) throws FoodException;

}

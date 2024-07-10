package com.infy.fos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.fos.dto.VendorDTO;
import com.infy.fos.dto.VendorDetails;
import com.infy.fos.entity.Vendor;
import com.infy.fos.exception.FoodException;
import com.infy.fos.repository.VendorRepository;

import jakarta.transaction.Transactional;

@Service(value = "vendorService")
@Transactional
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorRepository vendorRepository;
	@Override
	public String signUp(VendorDTO vendorDTO) throws FoodException {
		
		Optional<Vendor> optional=vendorRepository.findByEmailId(vendorDTO.getEmailId());
		//Optional<Vendor> op=vendorRepository.findByPhoneNo(vendorDTO.getPhoneNumber());
		Optional<Vendor> op=vendorRepository.findByMobileNumber(vendorDTO.getMobileNumber());
		if(optional.isPresent())
		{
			throw new FoodException("VendorService.VENDOR_ALREADY_EXISTS");
			
	    }
		else if(op.isPresent())
		{
			throw new FoodException("VendorService.VENDOR_WITH_THIS_MOBILE_NO_ALREADY_PRESENT");
		}
		else if(!(vendorDTO.getPassword().equals(vendorDTO.getConfirmPassword())))
		{
			throw new FoodException("VendorService.PASSWORD_NOT_MATCH");
		}
			
		
		
		
	   Vendor vendorEntity = new Vendor();
	   vendorEntity.setVendorId(vendorDTO.getVendorId());
	   vendorEntity.setEmailId(vendorDTO.getEmailId());
	   vendorEntity.setVendorName(vendorDTO.getVendorName());
	   vendorEntity.setPassword(vendorDTO.getPassword());
	   vendorEntity.setConfirmPassword(vendorDTO.getConfirmPassword());
	   vendorEntity.setDescription(vendorDTO.getDescription());
	   vendorEntity.setMobileNumber(vendorDTO.getMobileNumber());
	   vendorEntity.setImage(vendorDTO.getImage());
	   Vendor vendorEntity2=vendorRepository.save(vendorEntity);
	   return vendorEntity2.getEmailId();
	   
		
//		venEntity.setEmailId(userdto.getEmailId());
//		userEntity.setName(userdto.getName());
//		userEntity.setPassword(userdto.getPassword());
//		userEntity.setConfirmPassword(userdto.getConfirmPassword());
//		userEntity.setMobileNo(userdto.getMobileNo());
//		User userEntity2 =userRepository.save(userEntity);
//      return userEntity2.getEmailId();
		
	}
	
	
	
	
	
	@Override
	public Vendor VendorLogin(String emailId, String password) throws FoodException {
		
			Optional<Vendor> optional=vendorRepository.findByEmailId(emailId);
			   if(!optional.isPresent())
			     {
					throw new FoodException("VendorService.INVALID_EMAILID");
			      }
			   else
			       {
				  Vendor v=optional.get();
				  
					 if(v.getPassword().equals(password))
				       {
					     return v;
				        }
					 else
					 {
						 throw new FoodException("VendorService.INVALID_PASSWORD");
					 }
				   }
			
		}
	@Override
	public List<VendorDTO> getAllVendors() {
		Iterable<Vendor> vendors = vendorRepository.findAll();
		List<VendorDTO> vendorDTOs = new ArrayList<>();
		vendors.forEach(vendor -> {
			VendorDTO vendorDTO = new VendorDTO();
			vendorDTO.setVendorId(vendor.getVendorId());
			vendorDTO.setVendorName(vendor.getVendorName());
			vendorDTO.setEmailId(vendor.getEmailId());
			vendorDTO.setMobileNumber(vendor.getMobileNumber());
			vendorDTO.setImage(vendor.getImage());
			vendorDTO.setDescription(vendor.getDescription());
			vendorDTO.setPassword(vendor.getPassword());
			vendorDTO.setConfirmPassword(vendor.getConfirmPassword());
			vendorDTOs.add(vendorDTO);
		});
		return vendorDTOs;
	}
	@Override
	public VendorDetails getDetails(String emailId) throws FoodException {
		Optional<Vendor> op=vendorRepository.findByEmailId(emailId);
		//User user=op.orElseThrow(()->new FoodException("UserService.USER_NOT_FOUND"));
		if(op.isPresent()) 
		{
			Vendor v=op.get();
	        return new VendorDetails(v.getVendorId(), v.getVendorName(), v.getEmailId(), v.getMobileNumber());

		}

		else
		{
			throw new FoodException("VendorService.VENDOR_NOT_FOUND");
		}


	}
	
	
	}

	


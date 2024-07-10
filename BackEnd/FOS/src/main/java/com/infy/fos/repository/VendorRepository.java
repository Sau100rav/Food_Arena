package com.infy.fos.repository;


import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.fos.entity.Vendor;
@Repository

public interface VendorRepository extends CrudRepository<Vendor, Integer>{
//	Optional<Vendor> findByVendor_id( Integer vendor_id);

	Optional<Vendor> findByEmailId( String emailId);

	//Optional<Vendor> findByPhoneNo(String phoneNumber);

	Optional<Vendor> findByMobileNumber(String mobileNumber);
}

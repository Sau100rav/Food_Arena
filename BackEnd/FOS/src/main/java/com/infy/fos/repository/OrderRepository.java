package com.infy.fos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.infy.fos.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{
        List<Order>findByVendorNo(Integer vendorNo);


}


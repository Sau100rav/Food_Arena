package com.infy.fos.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.fos.entity.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	Optional<Product> findByProductId( Integer productId);

}

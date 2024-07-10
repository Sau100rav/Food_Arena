package com.infy.fos.service;

import java.util.List;

import com.infy.fos.dto.ProductDTO;
import com.infy.fos.entity.Product;
import com.infy.fos.exception.FoodException;

import jakarta.validation.Valid;

public interface CustomerProductService {
	List<ProductDTO> getAllProducts();
	//String addNewProduct(ProductDTO productDTO) throws FoodException;
	Integer addNewProduct(ProductDTO productDto) throws FoodException;
	//Integer updateProduct(Integer productId) throws FoodException;
	void deleteProductById(Integer productId) throws FoodException;

}

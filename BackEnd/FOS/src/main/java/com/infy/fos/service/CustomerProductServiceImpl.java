package com.infy.fos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.fos.dto.ProductDTO;
import com.infy.fos.entity.Product;
import com.infy.fos.exception.FoodException;
import com.infy.fos.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service(value = "customerProductService")
@Transactional
public class CustomerProductServiceImpl implements CustomerProductService {
	@Autowired
	private ProductRepository productRepository;

	
	public List<ProductDTO> getAllProducts(){
		Iterable<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setName(product.getName());
			productDTO.setProductId(product.getProductId());
			productDTO.setDescription(product.getDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setAvailableQuantity(product.getAvailableQuantity());
			productDTO.setImage(product.getImage());
			productDTO.setEstimatedTime(product.getEstimatedTime());
			productDTO.setVendor_id(product.getVendor_id());
			productDTOs.add(productDTO);
		});
		return productDTOs;
	}


	
	public Integer addNewProduct(ProductDTO productDTO) throws FoodException {
		// TODO Auto-generated method stub
		//Optional<Product> optional=productRepository.findByProductId(productDTO.getProductId());
		//if(optional.isPresent())
		//{
			//throw new FoodException("ProductService.PRODUCT_ALREADY_EXISTS");
			
			
		
		
		Product addnewproduct = new Product();
		
		Product product= new Product();
		product.setProductId(productDTO.getProductId());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setAvailableQuantity(productDTO.getAvailableQuantity());
		product.setImage(productDTO.getImage());
		product.setEstimatedTime(productDTO.getEstimatedTime());
		product.setVendor_id(productDTO.getVendor_id());
		Product product1=productRepository.save(product);
		
		
		return product1.getProductId();
		
		/*
		Product product= new Product();
		product.setProductId(productDTO.getProductId());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setAvailableQuantity(productDTO.getQuantity());
		Product product1=productRepository.save(product);
		
		
		
		return product1;
	}*/
		

}



	/*
	public Integer updateProduct(Integer productId) throws FoodException {
		// TODO Auto-generated method stub
		return null;*/
	@Override

	public void deleteProductById(Integer productId) throws FoodException {

		Optional<Product> optionalCustomer = productRepository.findById(productId);

		

		optionalCustomer.ifPresent(product -> productRepository.delete(product));

	}	
}

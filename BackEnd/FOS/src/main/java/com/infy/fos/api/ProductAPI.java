package com.infy.fos.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.fos.dto.ProductDTO;
import com.infy.fos.entity.Product;
import com.infy.fos.exception.FoodException;
import com.infy.fos.service.CustomerProductService;

import jakarta.validation.Valid;



@RestController
@Validated
@RequestMapping(value="/food-api")
@CrossOrigin
public class ProductAPI {
	@Autowired
	private CustomerProductService customerFoodService;
	
	@Autowired
	private Environment environment;
	
	
	
	//Log logger =LogFactory.getLog(ProductAPI.class)
	@GetMapping(value="/products")					//http://localhost:9090/food-api/products
	public ResponseEntity<List<ProductDTO>> getAllProducts() throws FoodException
	{
		List<ProductDTO> list = customerFoodService.getAllProducts();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@PostMapping(value="/AddProducts")
	public ResponseEntity<? > addProduct( @Valid @RequestBody ProductDTO productDto) throws FoodException{
		
		Integer addProduct=customerFoodService.addNewProduct(productDto);
		String successMessage = environment.getProperty("API.ADD_SUCCESS")+ addProduct ;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

		
		//return new ResponseEntity<>(addProduct,HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/product/{productId}")

	public ResponseEntity<String> deleteShippingAddress(@PathVariable("productId") Integer productId)

			throws FoodException {

 

		customerFoodService.deleteProductById(productId);

		String modificationSuccessMsg = environment.getProperty("CustomerAPI.PRODUCT_DELETED_SUCCESS");

		return new ResponseEntity<>(modificationSuccessMsg,HttpStatus.OK);

	}	
	/*@PutMapping(value="/Modify/{productId}")
	public ResponseEntity<Integer> modifyProduct(@PathVariable Integer productId) throws FoodException{
		customerFoodService.updateProduct(productId);
		
		return null;
	}*/
	/*{
   
    "name":"Pasta",
    "description":"Delicious Pasta",
    "price":40,
    "availableQuantity":1,
    "image":"../assets/foodimages/pasta.png"

}*/
}

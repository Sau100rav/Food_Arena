package com.infy.fos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="EK_ORDERED_PRODUCT")
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderedProductId;
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private Integer quantity;
	//private Integer makingTime;
	
//	 @OneToMany(mappedBy="order")
//     private Order order;
	

	
	
	public Integer getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(Integer orderedProductId) {
		this.orderedProductId = orderedProductId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
//	public Integer getMakingTime() {
//		return makingTime;
//	}
//
//	public void setMakingTime(Integer makingTime) {
//		this.makingTime = makingTime;
//	}

	
	
	
}


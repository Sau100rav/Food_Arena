package com.infy.fos.dto;


public class OrderedProductDTO {

	
	private Integer orderedProductId;
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private Integer quantity;
	//private Integer makingTime;
	
	
	public Integer getOrderedProductId() {
		return orderedProductId;
	}
	public void setOrderedProductId(Integer orderedProductId) {
		this.orderedProductId = orderedProductId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
//	public Integer getMakingTime() {
//		return makingTime;
//	}
//	public void setMakingTime(Integer makingTime) {
//		this.makingTime = makingTime;
//	}
	
	
	
	
	
}

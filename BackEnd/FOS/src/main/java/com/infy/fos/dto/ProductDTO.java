package com.infy.fos.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	private Integer productId;
	@NotBlank(message = "{Please Add Food Name}")
	@Pattern(regexp="([A-Za-z0-9-.])+(\\s[A-Za-z0-9-.]+)*", message="({Food.invalid.name}")
	private String name;
	@Size(min=10, message="{food.invalid.description}")
	private String description;
	@Min(value=1, message="{Food.invalid.price}")
	private Double price;
	@Min(value=1,message="{Food.invalid.quantity}")
	private Integer availableQuantity;
	private String image;
	private LocalDateTime estimatedTime;
	private Integer vendor_id;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	public LocalDateTime getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(LocalDateTime estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public Integer getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(Integer vendor_id) {
		this.vendor_id = vendor_id;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", availableQuantity=" + availableQuantity + ", image=" + image + ", estimatedTime="
				+ estimatedTime + ", vendor_id=" + vendor_id + "]";
	}	
}

package com.infy.fos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.fos.entity.Order;


public class OrderDTO {
	
	private Integer orderId;
	
	private LocalDate dateOfOrder;
   private String orderStatus;
   private LocalTime deliveryTime;
	
	private double totalPrice;
	private String customerName;
	private String customerEmailId;
	private Integer vendorNo;
	
	
	private List<OrderedProductDTO> orderedProducts;
	
	
	
	
	public List<OrderedProductDTO> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProductDTO> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	

    
    
    
    
    
    
    
    
    
    
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	
	

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}




	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getVendorNo() {
		return vendorNo;
	}

	public void setVendorNo(Integer vendorNo) {
		this.vendorNo = vendorNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerEmailId, customerName, dateOfOrder, deliveryTime, orderId, orderStatus,
				orderedProducts, totalPrice, vendorNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(customerEmailId, other.customerEmailId)
				&& Objects.equals(customerName, other.customerName) && Objects.equals(dateOfOrder, other.dateOfOrder)
				&& Objects.equals(deliveryTime, other.deliveryTime) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderStatus, other.orderStatus)
				&& Objects.equals(orderedProducts, other.orderedProducts)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(vendorNo, other.vendorNo);
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", dateOfOrder=" + dateOfOrder + ", orderStatus=" + orderStatus
				+ ", deliveryTime=" + deliveryTime + ", totalPrice=" + totalPrice + ", customerName=" + customerName
				+ ", customerEmailId=" + customerEmailId + ", vendorNo=" + vendorNo + ", orderedProducts="
				+ orderedProducts + "]";
	}
	
}

package com.infy.fos.service;

import java.util.List;

import com.infy.fos.dto.OrderDTO;
import com.infy.fos.dto.OrderStatus;

public interface OrderService {
	
	Integer placeOrder(OrderDTO orderDTO);
	List<OrderDTO> getAllOrders();

	List<OrderDTO> findOrdersByVendorNo(Integer vendorNo);
	void updateOrderStatus(Integer orderId, OrderStatus orderStatus);


}

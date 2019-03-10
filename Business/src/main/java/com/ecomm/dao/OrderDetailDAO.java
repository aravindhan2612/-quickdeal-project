package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDetailDAO {
	
	
	public boolean saveorOrder(OrderDetail orderDetail);
	public boolean updateCartItem(String username,int orderId);
	
}

package com.mapper;

import com.model.Item;
import com.model.Order;

public interface OrderMapper {
	void addOrder(Order order);
	void updateItem(Order order);
	Item findItem(String no);
}

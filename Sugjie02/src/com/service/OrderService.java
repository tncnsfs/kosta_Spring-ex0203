package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.ItemDao;
import com.model.Order;
import com.model.OrderDao;

@Service
public class OrderService {
	private OrderDao orderDao;
	private ItemDao itemDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor ={Exception.class})
	
	public void orderAction(Order order)throws Exception{ // 한 서비스가 트랜잭션 단위..커밋/롤백 
		orderDao.addOrder(order); //주문 등록

		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()){ //주문번호
			throw new Exception("재고부족");
	}
	itemDao.updateItem(order);
}
}






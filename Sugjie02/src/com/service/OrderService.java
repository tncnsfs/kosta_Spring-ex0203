package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.ItemDao;
import com.model.Order;
import com.model.OrderDao;

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
	
	
	// 트랜잭션 잡는법 -> 복잡한 트랜잭션 단위가 아닌 기본단위일때 propagation = Propagation.REQUIRED 사용 , 그리고 rollback 정의 
	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor = {Exception.class})
	
	public void orderAction(Order order)throws Exception{
		orderDao.addOrder(order); // 주문등록 
		
		// 주문번호와 제품번호 같게 하였음, 아래 코드 주문한 수량 < 주문수량보다 크면 
		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()){
			throw new Exception("재고부족");
		}
		
		// 재고수정 ,, 여기까지 모두 이루어져야 주문이 성공 
		itemDao.updateItem(order); 
	}
	
	

}

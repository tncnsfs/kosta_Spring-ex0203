package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;*/

import com.model.Order;
import com.service.OrderService;

@Controller
public class OrderController {

	private OrderService service;
	
	@Autowired
	public void setService(OrderService service){
		this.service = service;
	}
	
	@RequestMapping("/orderForm")
	public String orderForm(){
		return "transaction/orderForm";
		
	}
	
	@RequestMapping("order")
	public String orderDo(Order order){
		String view = "transaction/orderOk";
		
		try {
			service.orderAction(order);
		} catch (Exception e) {
			System.out.println("¿À·ù");
			view = "transaction/orderForm";
		}
		
		return view;
	}
		
}



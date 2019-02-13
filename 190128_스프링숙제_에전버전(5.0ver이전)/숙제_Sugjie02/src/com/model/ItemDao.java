package com.model;

import com.mapper.OrderMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}	

	public void updateItem(Order order){
		myTemplate.getMapper(OrderMapper.class).updateItem(order);
	}
	
	public Item findItem(String no){
		return myTemplate.getMapper(OrderMapper.class).findItem(no);
	}
}
















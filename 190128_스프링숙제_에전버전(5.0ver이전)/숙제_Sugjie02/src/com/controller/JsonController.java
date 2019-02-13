package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Board;
import com.model.BoardDao;
import com.model.Member;

//전문 json 만드는 어노테이션 + lib 하나 추가 
@RestController
public class JsonController {
	
	private BoardDao dao;
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	
	// Json 만들기 
	@RequestMapping("spring_json")
	public List<Member> spring_json(){
		List<Member> list = new ArrayList<>();
		list.add(new Member("홍길동", "aa@aa.com"));
		list.add(new Member("박길동", "bb@bb.com"));
		
		return list;
	}
	
	// Json 만들기 
	@RequestMapping("boardJson")
	public List<Board> boardJson(Model model){
		List<Board> list = dao.listBoard();
		
		model.addAttribute("list", list);
		
		return list;
	}


}

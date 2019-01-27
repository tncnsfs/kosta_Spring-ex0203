package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Board;
import com.model.BoardDao;

@Controller
public class BoardController {
	private BoardDao dao;

	/*
	@RequestMapping(value="/insert_form.do", method=RequestMethod.GET)
	public String insertform(Model model){ //데이터타입이 string이라면 , Model에서 받는다. 즉, 데이터 받는방법 데이터타입2가지 : modelandview, string-model
		model.addAttribute("title", "글쓰기2");
		
		return "insert_form";
	}*/
	
	@RequestMapping(value="/board_insert.do", method=RequestMethod.GET)
	public String insertform(@ModelAttribute("boardCommand") Board board, Model model){ //데이터타입이 string이라면 , Model에서 받는다. 즉, 데이터 받는방법 데이터타입2가지 : modelandview, string-model
		model.addAttribute("title", "글쓰기2");
		
		return "insert_form";
	}
	
	public BoardDao getDao() {
		return dao;
	}
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/board_insert.do", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors){ 
		
		if(errors.hasErrors()) //바인딩 객체에 에러가 있냐
		{
			System.out.println("에러 발생");
			return "insert_form";
			
		}
		dao.insert(board);
		
		return "redirect:board_list";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model){
		//비즈니스 처리
		List<Board> list = dao.listBoard();
		//데이터 가져오기
		model.addAttribute("list", list);
		
		return "list";
		//뷰 이름 정하기
	}

	/*@InitBinder
	protected void InitBinder(WebDataBinder binder){
		binder.setValidator(new BoardValidator());
	}*/

}

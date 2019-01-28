package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("/session_req.do")
	public String session_req(){
		
		return "session/session_req";
	}
	
	@RequestMapping("/session.do")
	public String session_exe(HttpServletRequest request){
		return "session/session_success";
	}
	
	
	// 공통관심 대상에 비포함 -> exe 메소드가 없기 때문 
	@RequestMapping("/session_add.do")
	public String session_add(){
		return "session/session_add";
				
	}
}

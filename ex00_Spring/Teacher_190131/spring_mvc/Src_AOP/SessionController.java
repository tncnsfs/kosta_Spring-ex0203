package kosta.controller;

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
	
	@RequestMapping("/session_add.do")
	public String session_add(){
		return "session/session_add";
	}
	
	
}








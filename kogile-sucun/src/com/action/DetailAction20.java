package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;

public class DetailAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("1. 확인합니다.");
		ListService serviceDetail20 = ListService.getInstance();
		System.out.println("2. 확인합니다.");
		serviceDetail20.detailBoardService20(request);
	
		System.out.println(request.getParameter("5. check"));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("detail20.jsp");

		return forward;
	}

}

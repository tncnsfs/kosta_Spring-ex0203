package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;

public class InsertAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ListService listservice = ListService.getInstance();
		listservice.insertlist(request);
		//String param1 = request.get
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list20.do");
		return forward;
	}

}

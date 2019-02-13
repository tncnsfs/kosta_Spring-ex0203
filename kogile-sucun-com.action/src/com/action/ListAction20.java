package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ListService;

public class ListAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		ListService listservice = ListService.getInstance();
		listservice.listBoardService20(request);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list20.jsp");

		return forward;
	}

}

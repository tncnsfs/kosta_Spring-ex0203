package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ListDao;
import com.service.Board;
import com.service.ListBoard;
import com.service.ListService;

public class DeleteAction20 implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ListService service = ListService.getInstance();
		service.deleteBoard(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("list20.do");
		
		return forward;
	}

}

package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckListDao;
import com.service.Board;
import com.service.CheckListService;


public class UpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckListService serviceUpdate = CheckListService.getInstance();
		serviceUpdate.updateBoard(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("list.do");
		
		return forward;
	}


}

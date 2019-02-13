package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckListDao;
import com.service.Board;
import com.service.CheckListService;

public class DetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		CheckListService serviceDetail = CheckListService.getInstance();
		serviceDetail.detailBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("detail.jsp");

		return forward;
	}

	
}

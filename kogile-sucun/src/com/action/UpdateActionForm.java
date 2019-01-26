package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckListDao;
import com.service.Board;
import com.service.CheckListService;

public class UpdateActionForm implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		CheckListDao dao = CheckListDao.getInstance();
		request.setCharacterEncoding("utf-8");

		String str = request.getParameter("checklist_no");
		int checklist_no = 0;
		if (str != null) {
			checklist_no = Integer.parseInt(str);
		}

		Board updateboard = dao.detailBoard(checklist_no);
		request.setAttribute("updateboard", updateboard);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 
		forward.setPath("update_form.jsp");
		return forward;
	}

}

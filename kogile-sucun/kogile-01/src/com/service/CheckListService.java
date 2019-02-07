package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.action.ActionForward;
import com.dao.CheckListDao;


public class CheckListService {
	private static CheckListDao dao;
	private static CheckListService service = new CheckListService();
	private static final int PAGE_SIZE = 2;
	
	public static CheckListService getInstance(){
		dao = CheckListDao.getInstance();
		return service;
	}
	
	public int deleteBoard(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		Board deleteboard = new Board();
		deleteboard.setChecklist_no(Integer.parseInt(request.getParameter("checklist_no")));
		
		
		return dao.deleteBoard(deleteboard);
	}
	
	
	
	public int updateBoard(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		Board updateboard = new Board();
		updateboard.setChecklist_no(Integer.parseInt(request.getParameter("checklist_no")));
		updateboard.setCheck_title(request.getParameter("check_title"));
		
		return dao.updateBoard(updateboard);
	}
	
//	----------------------------------------------------------------------------------------
	public int insertchecklist(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		Board insertboard = new Board();
		insertboard.setCheck_title(request.getParameter("check_title"));
		insertboard.setP_no(Integer.parseInt(request.getParameter("p_no")));
		
		System.out.println("insertboard" + insertboard.getCheck_title()+
				"-" + insertboard.getP_no());
		
		return dao.insertchecklist(insertboard);
	}
	
	
//	----------------------------------------------------------------------------------------
	public Board detailBoardService(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		Board detailboard = null;
		int checklist_no  = Integer.parseInt(request.getParameter("checklist_no"));

		detailboard = dao.detailBoard(checklist_no);
		System.out.println("detailboard=>" + checklist_no);
		request.setAttribute("detailboard", detailboard);
		
		
		return detailboard;
	}
//	----------------------------------------------------------------------------------------
	public List<Board> listBoardService(HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		List<Board> checklist = dao.checklistBoard();
		System.out.println(checklist);
		request.setAttribute("checklist", checklist);
		
		return checklist;
	}

//	----------------------------------------------------------------------------------------
	
}

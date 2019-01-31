package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.dao.ListDao;


public class ListService {
	private static ListDao dao;
	private static ListService service = new ListService();
	
	public static ListService getInstance(){
		dao = ListDao.getInstance();
		return service;
	}
	
	public int deleteBoard(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ListBoard deleteboard20 = new ListBoard();
		deleteboard20.setList_no(Integer.parseInt(request.getParameter("list_no")));
		
		return dao.deleteBoard20(deleteboard20);
	}
	
	public int updateBoard20(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");

		ListBoard updateboard20 = new ListBoard();
		updateboard20.setList_no(Integer.parseInt(request.getParameter("list_no")));
		updateboard20.setList_info(request.getParameter("list_info"));
		
		return dao.updateBoard20(updateboard20);
	}
	
	public int insertlist(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		ListBoard insertboard = new ListBoard();
		System.out.println("debug1" + request.getParameter("checklist_no"));
		insertboard.setList_info(request.getParameter("list_info"));
		insertboard.setChecklist_no(Integer.parseInt(request.getParameter("checklist_no")));
		
		System.out.println("insertboard20" + insertboard);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("checklist_no", request.getParameter("checklist_no"));
		return dao.insertlist(insertboard);
	}
	
//	----------------------------------------------------------------------------------------
	public ListBoard detailBoardService20(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ListBoard detailboard20 = null;
		int list_no  = Integer.parseInt(request.getParameter("list_no"));
		//int checklist_no  = Integer.parseInt(request.getParameter("checklist_no"));

		detailboard20 = dao.detailBoard20(list_no);
		request.setAttribute("detailboard20", detailboard20);
		System.out.println("4. detailboard list_no=> " + list_no);
		System.out.println("5. detailboard20 service: " + detailboard20);
		
		return detailboard20;
	}

//	----------------------------------------------------------------------------------------
	public List<ListBoard> listBoardService20(HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		List<ListBoard> list = null;
		System.out.println("service01+");
		
		list = dao.listBoard20(Integer.parseInt(request.getParameter("checklist_no")));
		System.out.println("debug" + request.getParameter("checklist_no"));
		System.out.println("listboard=:service=> " + list);
		request.setAttribute("list", list);
		
		
		return list;
		
	}
//	----------------------------------------------------------------------------------------
	
}

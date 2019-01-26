package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionForward;
import com.action.DeleteAction;
import com.action.DeleteAction20;
import com.action.DetailAction;
import com.action.DetailAction20;
import com.action.InsertAction;
import com.action.InsertAction20;
import com.action.InsertActionForm;
import com.action.InsertActionForm20;
import com.action.ListAction;
import com.action.ListAction20;
import com.action.UpdateAction;
import com.action.UpdateAction20;
import com.action.UpdateActionForm;
import com.action.UpdateActionForm20;


@WebServlet("*.do")
public class listController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		insertForm.do, insertAction.do, list.do, detail.do
//	     /MVC/insertForm.do
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		System.out.println("requestURI" + requestURI);
		System.out.println("contextPath" + contextPath);
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println("command :" + command + "\n");
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("insert_form.do")) {
			action = new InsertActionForm();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("insertAction.do")) {
			action = new InsertAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else if(command.equals("list.do")) {
			action = new ListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("detail.do")){
    		action = new DetailAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("delete.do")) {
    		action = new DeleteAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateForm.do")){
    		action = new UpdateActionForm();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateAction.do")){
    		action = new UpdateAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	else if(command.equals("insert_form20.do")) {
			action = new InsertActionForm20();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else if(command.equals("insertAction20.do")) {
			action = new InsertAction20();
			try {
				forward = action.excute(request, response);
				System.out.println("command" + forward.getPath());
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else if(command.equals("list20.do")) {
			System.out.println("debug list20.do");
			action = new ListAction20();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("detail20.do")){
    		action = new DetailAction20();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("delete20.do")) {
    		action = new DeleteAction20();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateForm20.do")){
    		action = new UpdateActionForm20();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateAction20.do")){
    		action = new UpdateAction20();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}  	

		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

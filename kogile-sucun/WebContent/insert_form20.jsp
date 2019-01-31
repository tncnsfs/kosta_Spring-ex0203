<%@page import="com.service.ListBoard"%>
<%@page import="com.service.ListService"%>
<%@page import="com.service.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.service.CheckListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	ListService listservice = ListService.getInstance();
	
/* 	List<ListBoard> listboard = listservice.listBoardService20(request);
	request.setAttribute("listboard", listboard); */
	
	int insert20 = listservice.insertlist(request);
	request.setAttribute("insert20", insert20);
	
/* 	
int insertlist(ListBoard listboard);
	List<ListBoard> listBoard20(int checklist_no);
	ListBoard detailBoard20(int list_no);
	int updateBoard20(ListBoard listboard);
	int deleteBoard20(ListBoard listboard); */
		
		
%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<hr>

		<form action="insertAction20.do" method="post">
<!-- 			<input type="hidden" name = "checklist_no"> -->
			list내용: 
			<input type="text" name="list_info"><br>
			체크리스트no: 
			<input type="text" name="checklist_no"><br>
			 <input	type="submit" value="list등록">
		</form>

</body>
</html>





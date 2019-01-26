
<%@page import="com.service.ListBoard"%>
<%@page import="java.util.List"%>
<%@page import="com.service.ListService"%>
<%@page import="com.service.CheckListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	ListService listservice = ListService.getInstance();
	
	List<ListBoard> list = listservice.listBoardService20(request);
	request.setAttribute("list", list);
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	

	

	<ul>
		<li>list-no: ${detailboard20.list_no }</li>
		<li>리스트내용: ${detailboard20.list_info }</li>
		<li>체크넘버:   ${detailboard20.checklist_no }</li>
		
		<li>
			<a href="insert_form20.do?list_no=${detailboard20.list_no }">등록</a>
			<a href="updateForm20.do?list_no=${detailboard20.list_no }">수정</a>
			<a href="delete20.do?list_no=${detailboard20.list_no }">삭제</a>
			<a href="list20.do">목록</a>
		</li>
	<br>
	<tr>
	</ul>
	
</body>
</html>

<%@page import="com.service.CheckListService"%>
<%@page import="java.util.List"%>
<%@page import="com.service.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	request.setCharacterEncoding("utf-8");
	CheckListService service = CheckListService.getInstance();
	
	List<Board> checklist = service.listBoardService(request);
	request.setAttribute("checklist", checklist);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>글목록보기</h3>
	<a href="insert_form.jsp">글쓰기</a><br>
		
	<table width="500" border="1" cellpadding="3" cellspacing="0">
		<form action="insertAction.do" method="post" >
			check제목 : <input type="text" name="check_title">
			p_no : <input type="text" name="p_no">
			<p>
			<input type="submit" value="check등록">
		</form>
		
		<br><br>
		<tr>
			<td>체크번호</td>
			<td>체크내용</td>
		</tr>
		<c:forEach var="cls" items="${checklist}">
			<tr>
				<td>${cls.checklist_no }</td>
				
				<td>
				<%-- <a href="list20.do?checklist_no=${cls.checklist_no }">${cls.check_title} --%>
				<a href="detail.do?checklist_no=${cls.checklist_no }">${cls.check_title}
				<%-- <input type="hidden" name="checklist_no" value="${ls.checklist_no }"> --%>
				</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>	<br><br>
	<a href="list20.jsp">list목록보기</a>
	<a href="list.jsp">목록보기</a>
	
</body>
</html>
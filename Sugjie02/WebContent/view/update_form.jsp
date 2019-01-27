<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<h3>${seq }</h3>
<body>
	<form:form action="board_update.do" method="post" commandName="boardCommand">
		<form:input type="hidden" name="seq" value="${seq}"/> 
		제목 : <form:input type="text" name="title" value="${seq}"/><br>
		내용: 
		<form:textarea rows="6" cols="70" path="contents"/>
		<br>
		<input type="submit" value="수정완료">
	</form:form>
</body>
</html>
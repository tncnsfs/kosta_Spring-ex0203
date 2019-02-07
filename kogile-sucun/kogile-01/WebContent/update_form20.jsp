<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateAction20.do" method="post">
	<input type="hidden" name="list_no" value="${updateboard20.list_no}"> 
	제목 : <input type="text" name="list_info" value="${updateboard20.list_info }"><br>
	<br>
	<input type="submit" value="수정완료">
</form>
</body>
</html>
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
	<form action="updateAction.do" method="post">
	<input type="hidden" name="checklist_no" value="${updateboard.checklist_no}"> 
	제목 : <input type="text" name="check_title" value="${updateboard.check_title }"><br>
	<br>
	<input type="submit" value="수정완료">
</form>
</body>
</html>
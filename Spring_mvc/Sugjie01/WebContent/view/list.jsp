<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>글목록보기</h3>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.seq }</td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td>${board.hitcount }</td>
				<td>${board.regdate }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>










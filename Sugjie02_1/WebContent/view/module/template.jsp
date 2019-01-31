<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더영역 -->
	<tiles:insertAttribute name="header"/>
	<hr>
	
	<!-- 바디영역 -->
	<tiles:insertAttribute name="body"/>
	<hr>
	
	<!-- 푸터영역 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>








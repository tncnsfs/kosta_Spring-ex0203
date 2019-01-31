<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>주문내역</h3>
	<form action="order.do" method="post">
		<input type="hidden" name="no" value="100">
		<input type="hidden" name="name" value="pc">
		<input type="hidden" name="price" value="10000">
		컴퓨터 : 
		<select name="amount">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="1000">1000</option>
			<option value="5000">5000</option>
		</select>
		<br><br>
		<input type="submit" value="주문">
	</form>
</body>
</html>











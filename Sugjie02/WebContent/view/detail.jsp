<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%-- <li>번호:${board.seq } 를 그냥 seq 로 수정 </li> --%>
		<li>번호: ${seq }</li>
		<li>제목: ${title }</li>
		<li>작성자: ${writer }</li>		
		<li>내용: ${contents }</li>
		<li>
			<a href="board_insert.do">등록</a>
			<a href="board_update.do?seq=${seq }">수정</a>
			<a href="delete.do?seq=${seq }">삭제</a>
			<a href="board_list.do">목록</a>
		</li>
	</ul>
	
</body>
</html>











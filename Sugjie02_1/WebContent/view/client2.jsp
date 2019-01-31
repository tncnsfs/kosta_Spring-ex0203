<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script   src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){		
		$.getJSON("boardJson", function(data){
			//var data = responseData.list;
			//alert(data);
			$.each(data, function(index, board){
				$('#result').append('<tr><td>' + board.seq + '</td>'
						+ '<td>' + board.writer + '</td>'
						+ '<td>' + board.title + '</td>'
						+ '<td>' + board.contents + '</td>'
						+ '<td>' + board.hitcount + '</td>'
						+ '<td>' + board.fname + '</td></tr>');
			});
		});
	});
</script>
</head>
<body>
	<table id="result" border="1">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>내용</td>
			<td>카운트</td>
			<td>파일명</td>
		</tr>
	</table>
</body>
</html>










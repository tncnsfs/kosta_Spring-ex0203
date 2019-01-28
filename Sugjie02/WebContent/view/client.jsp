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
		$.getJSON("spring_json", function(data){
			//var data = responseData.list;
			//alert(data);
			$.each(data, function(index, member){
				$('#result').append('<tr><td>' + member.name + '</td>'
						+ '<td>' + member.email + '</td></tr>');
			});
		});
	});
</script>
</head>
<body>
	<table id="result" border="1">
		<tr>
			<td>이름</td>
			<td>이메일</td>
		</tr>
	</table>
</body>
</html>










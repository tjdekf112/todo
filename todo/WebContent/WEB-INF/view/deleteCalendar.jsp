<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<h1 class="table container mt-3">정말로 삭제 하시겠습니까?</h1>
	<form id="deleteForm" method="post" action ="${pageContext.request.contextPath}/member/delete">
		<input type="hidden" name="todoNo" value= "${todoNo}">
		<input type="hidden" name="todoDate" value="${todoDate}">	
	<button class="table container mt-3" id = "btn" type ="submit">예</button>
	<table class="table container mt-3">	
		<tr class="table container mt-3">
			<td>
				<a href="${pageContext.request.contextPath}/member/calendar">달력으로</a>
			</td>
		</tr>
	</table>
	</form>
	<script>
		$('#btn').click(function(){
			$('#deleteForm').submit();
		});
	</script>
</body>
</html>
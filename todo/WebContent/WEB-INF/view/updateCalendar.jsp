<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateCalendar</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<h1 class="table container mt-3">내용 수정</h1>
	
	<form id="updateForm" method="post" action ="${pageContext.request.contextPath}/member/update">
	<table border="1" class="table container mt-3">
		<tr>
			<td class="table table-dark table-hover">작성자 번호 : </td>
			<td><input type="text" name="todoNo" value= "${todoNo}" readonly="readonly"></td>
		</tr>
		<tr>
			<td class="table table-dark table-hover">오늘 날짜 : </td>
			<td><input type="text" name="todoDate" value="${todoDate}" readonly="readonly"></td>
		</tr>
		<tr>
			<td class="table table-dark table-hover">수정할 내용 : </td>
			<td><textarea rows="3" cols="50" name="todoContent" id="todoContent"></textarea></td>
		</tr>
		<tr>
			<td>
				<button id = "btn" type ="button">수정</button>
			</td>
		</tr>
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/member/calendar">달력으로</a>
			</td>
		</tr>
	</table>
	</form>
		 <script>
		$('#btn').click(function(){
			// 버튼을 click했을 때
			if($('#todoContent').val() == ''){//id가 공백이면
				alert('todoContent를 입력하세요');
			return;
			}else{
			$('#updateForm').submit();
			}
		});
	</script>
</body>
</html>
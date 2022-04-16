<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1 class="table container mt-3">회원가입</h1>
		<form class="form-inline" id="insertloginForm" method="post" action="${pageContext.request.contextPath}/insert">
		<table class="table container mt-3">
		<tr>
			<td>
			<div class="table table-dark table-hover">
				memberId :
				<input type="text" name="memberId" id="memberId">
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="table table-dark table-hover">
				memberPw :
				<input type="password" name="memberPw" id="memberPw">
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<button id="btn" type="button">등록</button>
			</td>
		</tr>

		</table>
	</form>
 <script>
	$('#btn').click(function(){
		// 버튼을 click했을 때
		if($('#memberId').val() == ''){//id가 공백이면
			alert('memberId를 입력하세요');
		return;
		}else if($('#memberPw').val() ==''){	//pw 공백이면
			alert('memberPw를 입력하세요.');
		return;
		}else{
		$('#insertloginForm').submit();
		}
	});
</script>
</body>
</html>
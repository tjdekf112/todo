<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>관리자 로그인</h1>
		<h1 class="table container mt-3">login</h1>
	<form class="form-inline" id="loginForm" method="post" action="${pageContext.request.contextPath}/adminlogin">
		<table class="table container mt-3">
		<tr>
			<td>
			<div class="table table-dark table-hover">
				AdminId :
				<input type="text" name="adminId" id="adminId">
			</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="table table-dark table-hover">
				AdminPw :
				<input type="password" name="adminPw" id="adminPw">
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<div>
					<button id="btn" type="button">로그인</button>
				</div>
			</td>
		</tr>
		</table>
	</form>
	
	 <script>
		$('#btn').click(function(){
			// 버튼을 click했을 때
			if($('#adminId').val() == ''){//id가 공백이면
				alert('adminId를 입력하세요');
			return;
			}else if($('#adminPw').val() ==''){	//pw 공백이면
				alert('adminPw를 입력하세요.');
			return;
			}else{
			$('#loginForm').submit();
			}
		});
	</script>
</body>
</html>
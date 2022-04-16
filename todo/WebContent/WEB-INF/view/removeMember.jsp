<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<h1 class="table container mt-3">회원 탈퇴</h1>
	<form id="removeMemberForm" method="post" action="${pageContext.request.contextPath}/member/removeMember">
		<table class="table container mt-3">
		<tr>
			<td>
				<div >
					<!--  memberId : 히든으로 감춰서 자동으로 값이 넘거가게 설정-->
					<input type="hidden" name="memberId" id="memberId" value="${loginMember.getMemberId()}">
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
				<div>
					<button id="btn" type="button">회원 탈퇴</button>
				</div>
			</td>
		</tr>
		</table>
	</form>
		 <script>
		$('#btn').click(function(){
			// 버튼을 click했을 때
			if($('#password').val() == ''){//id가 공백이면
				alert('password를 입력하세요');
			return;
			}else{
			$('#removeMemberForm').submit();
			}
		});
	</script>
</body>
</html>
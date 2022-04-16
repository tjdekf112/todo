<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"><link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body class="table-primary">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container; float-left" style="width:30%; margin-left: 450px; margin-right: 10px;" >
	
<div class="btn alert-light" style="width:100%; border-radius:5%; ">
	<h1 class="table container mt-3" style="width:30%" >login</h1>
	<br>
	<hr color="#FFDEAD" style="width:90%">
	<form class="form-inline" id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
		<table class="table container mt-3" style="width:20%">

			<div style="margin-left:140px ">
				ID :
				<input style="margin-left:10px" type="text" name="memberId" id="memberId" value="admin">
				
			</div>

		<hr color="#FFDEAD" style="width:90%">
			<div style="margin-left:140px">
				PW :
				<input type="password" name="memberPw" id="memberPw" value="1234">
			</div>
		<hr color="#FFDEAD" style="width:90%">
				
					<button style="width:80%; margin-left:50px" class="btn btn-primary disabled btn-block" id="btn" type="button">로그인</button>
				
				
				<div style="text-align: center; width:100%">
					<a href="${pageContext.request.contextPath}/insert">				
					<br>
					회원가입</a>
					<br>
					<br>
				</div>

		</table>
	</form>
	</div>
	</div>
	
		<table class="table container;btn alert-light" style="width:20%;border-radius:5%">
		<tr>
			<td style="text-align:center">noticeTitle</td>
		<tr>
		<c:forEach var="n" items="${noticeList}">
			<tr>
				<td>
				<div><a class="text-dark" href="${pageContext.request.contextPath}/noticeOne?noticeNo=${n.noticeNo}">${n.noticeTitle}</a></div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="table container" style="width:22%;border-radius:5%;margin-left: 1020px; ">
		 <span class="btn alert-light btn-block"><a href="${pageContext.request.contextPath}/adminlogin" >관리자 로그인</a></span>
		 <!-- 1) adminLigonController.doget(), adminLogin.jsp -->
		  <!--2) adminLigonController.doPost(), /admin/index, AdminIndexController.doget(), adminIndex.jsp -->
	</div>
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
			$('#loginForm').submit();
			}
		});
	</script>

</body>
</html>
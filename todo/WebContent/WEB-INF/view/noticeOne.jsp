<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="width:45%">
	<br>
	<br>
	<h1 class="alert-primary" style="height:150px; text-align: center" ><br>공지사항</h1>
		<table   class="table container" style="text-align: center;width:80%;">
		<tr>
			<td>
				공지사항 번호
			</td>

			<td>${notice.noticeNo}</td>
			</tr>
			
			<tr>
			<td>
				제목
			</td>

			<td>${notice.noticeTitle}</td>
			</tr>
			<tr>
			<td>
				내용
			</td>

			<td>${notice.noticeContent}</td>
			
			</tr>
			<tr>
			<td>
				작성한 날짜
			</td>

			<td>${notice.createDate}</td>
			</tr>
			
			<tr>
			<td>
				수정한 날짜
			</td>

			<td>${notice.updateDate}</td>
		</tr>

		</table>
		
		<a href="<%=request.getContextPath() %>/login">이전</a>
		</div>
</body>
</html>
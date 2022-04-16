<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>공지사항</h1>
		<table class="table container mt-3">
		<tr>
			<td>
				noticeNo
			</td>
			<td>
				noticeTitle
			</td>
			<td>
				noticeContent
			</td>
			<td>
				createDate;
			</td>
			<td>
				updateDate;
			</td>
		</tr>
		
		<c:forEach var="n" items="${noticeList}">
			<tr>
				<td>${n.noticeNo}</td>
				<td>${n.noticeTitle}</td>
				<td>${n.noticeContent}</td>
				<td>${n.createDate}</td>
				<td>${n.updateDate}</td>
			</tr>
		</c:forEach>
		
		
		</table>
</body>
</html>
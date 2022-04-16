<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoList.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
   <div class="container">
      <h1>${todoDate} 일정 목록</h1>
      <table border="1" class="table container mt-3">
         <tr>
            <td class="table table-dark table-hover">todoDate</td>
            <td class="table table-dark table-hover">todoContent</td>
            <td class="table table-dark table-hover">createDate</td>
            <td class="table table-dark table-hover">updateDate</td>
            <td class="table table-dark table-hover">수정</td>
            <td class="table table-dark table-hover">삭제</td>
         </tr>
         <c:forEach var="t" items="${todoList}">
            <tr class="table table-dark table-hover">
               <td>${todoDate}</td>
               <td>${t.todoContent}</td>
               <td>${t.createDate}</td>
               <td>${t.updateDate}</td>
               <td><a href="${pageContext.request.contextPath}/member/update?todoNo=${t.todoNo}&todoDate=${todoDate}">[수정]</a></td>
               <td><a href="${pageContext.request.contextPath}/member/delete?todoNo=${t.todoNo}&todoDate=${todoDate}">[삭제]</a></td>
            </tr>
         </c:forEach>
      </table>
      <hr>
      <h1>일정 추가</h1>
      <form class="form-inline" method="post" id="addListForm" action="${pageContext.request.contextPath}/member/addTodo">
         <!-- AddTodoController.class -->
         <table class="table container mt-3">
         	<tr>
         		<td>
			         <div>
			            오늘 날짜 : <input type="text" name="todoDate" value="${todoDate}" readonly="readonly">
			         </div>
	         	</td>
	         </tr>
	         <tr>
	         	<td>
			         <div>
			            일정 내용
			            <textarea rows="3" cols="50" name="todoContent" id="todoContent"></textarea>
			         </div>
	         	</td>
	         </tr>
     	     <tr>
	         	<td>
			         <div>
			         	<input type="color" name="fontColor" >
			         </div>
	         	</td>
	         </tr>
	         
	         <tr>
	         	<td>
	        		 <button type="button" id="addBtn">저장</button>
	         	</td>
	         </tr>
         </table>
         <tr>
         	<td>
         		<a href="${pageContext.request.contextPath}/member/calendar">이전</a>
         	</td>
         </tr>
      </form>
   </div>
   <script>
      // 버튼을 클릭했을 때
      $('#addBtn').click(function(){   
         if($('#todoContent').val() == '') { // textarea가 공백이면
            alert('내용을 입력하세요');
            return;
         }
         $('#addListForm').submit();
      });
   </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body  >
<div class="container" >
	<div class="p-3 mb-2 bg-light text-dark">
   <h3 class="alert-primary" style="height:80px; text-align: center" ><br>CALENDAR</h3>
   
   <!-- 달력 + todo -->
   
   

   <table class="table" style="width:75%;">
      <tr class=table-primary>
         <td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td>
      </tr>
      <tr class="alert-info">
         <!-- JSTL for문 -->
         <c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
            <c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
               <td class=alert-light height=80 width=50 style="word-break:break-all">
                  <a href="${pageContext.request.contextPath}/member/todoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">${i-startBlank}
                  </a>
               <div>
               	<!-- 날짜별 일정 -->
               	<c:forEach var="todo" items="${todoList }">
               		<c:if test="${(i-startBlank) == todo.todoDate.substring(8)}">
               			<div style="color:${todo.fontColor};">${todo.todoContent}</div>
               		</c:if>
               	</c:forEach>
               	
               </div>
               
               
               </td>
               
            </c:if>
            <c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
               <td class="alert-light">&nbsp;</td>
            </c:if>
            
            <c:if test="${i%7 == 0}">
               <tr></tr>
            </c:if>
         </c:forEach>
      </tr>
      
	   <div  class="float-right">
	      <h1 class="table container">
	      <br>
	      <div style="border-radius:5%" class="alert-primary">
	     	 <div style=" text-align: right; font-size:larger">${targetYear}년</div>
	     	 <div style=" text-align: right; font-size:larger"> ${targetMonth}월</div>
	      </div>
   		<span class="btn alert-light" style="border-radius:5%;"><a style = "font-size:small; border-radius:5% " href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">←이전</a></span>
   		
   		<span class="btn alert-light" style="border-radius:5%;"><a style = "font-size:small; border-radius:5% " href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">다음→</a></span>
  		
   </h1>
   <div>
   <br>
   <div class="table container" style = "font-size:large;" >
   		이달의 total todo
   </div>
   <div  class="alert-primary" style="font-size:50pt;  text-align: center; border-radius:5%" >
   ${todoList.size()}
   </div>
		<br>
		<br>

		<br>
            <div><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
  			 <a href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a></div>
  			 <br>
   		<div>제작자 : 최성석</div>
   </div>
   </table>
   </div>
</div>
   
   
</body>
</html>
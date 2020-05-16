<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet" />
<title>나의 6개월</title>
</head>

 <body>
	<div class='main_window'>
 		<h1><a href="/">main</a></h1>
 		<h1><a href="/board">게시판</a></h1> 		
 	</div>
 	
 	<c:if test= "${member == null }">
 	<form role="form" method="post" action="login">
 		<table id='login_window'> 		
 			<tr>
 				<td>아이디  :  </td>
        		<td><input type="text" name="id" id="userId" required="required"></td>
 			</tr>
 			<tr>
 				<td>비밀번호  :  </td>
 				<td><input type="password" name='pw' id='userPw' required="required"></td>
 			</tr>
 			<tr>
 				<td><button name="button1" id='button1' type="submit">로그인</button></td>
 				<td><input type="button" id='button2' onclick="location.href='sign_up'" value="회원가입"/></td>
 			</tr>
 	</table>
 	<input type="hidden" name="target" value="${target}" />
 	</form> 	
 	
 	</c:if>
 	<c:if test="${msg == false}">
 		<h1>로그인에 실패했습니다. 아이디와 패스워드를 다시 입력해주세요</h1>
 	</c:if>
 	<c:if test="${member != null}">
 	<div id='login_result'>
 	<h1>${member.id}님 환영합니다</h1>
 	<button id='button3' onclick="location.href='logout'">로그아웃</button>	
 	</div>
 	</c:if>
	 	
</body>
<script>
</script>
</html>

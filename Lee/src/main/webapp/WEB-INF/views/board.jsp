<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/board.css"/>" rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">
	#main_window{
		width: 500px;
        text-align: left; 
        
	}
	
	#main_window h1{
		 width: 100px;
        height: 100px;
        display: inline-block; 
        color: black;
        vertical-align: baseline; 
	}
	
	#loginId{
		text-align: right;
	}
	
</style> -->
</head>
<body>
<div class='main_window'>
 		<h1><a href="/">main</a></h1>
 		<h1><a href="/board">게시판</a></h1>
 		<c:if test="${member != null}"> 	
			<h2 id="loginId">${member.id}</h2>
		</c:if>
		<c:if test="${member == null}"> 	
			<h2 id="loginId"><a href="/">로그인 해주세요</a></h2>
		</c:if>
 	</div>

<table>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<c:forEach items="${list}" var= "list">
	<tr>
		<td><c:out value="${list.board_number}"></c:out></td>
		<td><a href="${path}/board/detail_board?board_number=${list.board_number}">
		<c:out value="${list.board_title}"></c:out></a></td>
		<td>
		<c:out value="${list.board_writer}"></c:out></td>
		<td><c:out value="${list.board_date}"></c:out></td>
	</tr>
</c:forEach>

</table>
<input type="button" id="writer" value="작성하기" onclick="location.href='board/write'">


</body>
</html>
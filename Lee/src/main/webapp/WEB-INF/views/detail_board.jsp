<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#main_window{
		width: 500px;
        text-align: left; 
        
	}
	
	#main_window h1{
		 width: 100px;
        height: 100px;
        display: inline-block; 
        color: white;
        vertical-align: baseline; 
	}
	#loginId{
		text-align: right;
	}
</style>
</head>
<body>
<div class='main_window'>
 		<h1><a href="/">main</a></h1>
 		<h1><a href="/board">게시판</a></h1>
 		<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
 		<c:if test="${member.id != null}"> 		
 		<h2 id="loginId">${member.id}</h2>
 		<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script> 
 		<script>
 			$(document).ready(function(){
 				$("#insertComment").removeAttr("disabled");	
 			})
 		</script>
 		</c:if>
 		<c:if test="${member.id == null }">
 		<h2 id="loginId"><a href="/">로그인 해주세요</a></h2>
 		</c:if>
 	</div>

<form name="form1" method="post" action="/baord/detail_board/update">
	<div>
		게시판 번호: <input type="text" name="board_number" id="board_number" value="${dto.board_number}" readonly> 
	</div>
	<div>
		작성일자 : <input type="text" value="${dto.board_date}" readonly>
	</div>
	<div>
		조회수 : ${dto.board_viewcnt}
	</div>
	<div>
		제목
		<input name="board_title" id="title" class="deletereadonly" value="${dto.board_title}" readonly>
	</div>
	<div>
		내용
		<textarea name="board_context" id="context" class="deletereadonly" rows="10" cols="80" readonly>${dto.board_context}</textarea>
	</div>
	<div>
		작성자
		<input name="board_writer" id="writer" value="${dto.board_writer}" readonly>
	</div>
	
	
	<c:if test="${member.id == dto.board_writer}">
		<input type="submit" value="수정" >
		<input type="button" id="delete" value= "삭제">
		<script type="text/javascript">
		$(document).ready(function(){
			$(".deletereadonly").removeAttr('readonly');
			$("#delete").click(function(){
				document.form1.action="${path}/board/detail_board/delete";
				document.form1.submit();
			})
		});
		
		</script>
	</c:if>
	</form>
	<textarea name="comment_context" id="comment_context" rows="3" cols="100" placeholder="댓글 입력"></textarea>
	<button type="button" id="insertComment" disabled>작성</button>
	
	<table id="commentList">
	<c:forEach items="${comment}" var= "comment">
	<tr>
		<td><c:out value="${comment.comment_writer}"></c:out></td>
		<td> : </td>
		<td><c:out value="${comment.comment_context}"></c:out></td>
	</tr>
	</c:forEach>
	</table>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script>
		$(document).ready(function(){
			$("#insertComment").click(function(){
				var query = {comment_context : $("#comment_context").val(),
						comment_board_number : $("#board_number").val(),
						comment_writer : $("#loginId").text()};
				
				if($("#comment_context").val() == ""){
					alert("댓글을 입력하세요")
					return false;
				}
				
				$.ajax({
					url: "/board/detail_board/commentWriter",
					type : "post",
					data : query,
					success :function(){
						$("#comment_context").val("");
						alert("댓글 등록 완료");
						listReply();
					}
				})
			})
		})
		
		function listReply(){
			$.ajax({
				type: "get",
				url: "${path}/board/detail_board/listJson.do?bno=${dto.board_number}",
				success: function(result){
					console.log(result);
					var output = "<table>";
					for(var i in result){
						output +="<tr>";
						output +="<td>" + result[i].comment_writer + "</td>";
						output +="<td> : </td>" 
						output +="<td>" + result[i].comment_context+"</td>";
						output += "</tr>"
					}
					output += "</table>";
					$("#commentList").html(output);
				}
			})
			
		}
	</script>
	
</body>
</html>
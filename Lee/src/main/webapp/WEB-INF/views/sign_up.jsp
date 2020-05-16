<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/sign_up/insertId" method="post">
	<div>
	<input type="text" name="id" id="id" placeholder="아이디를 입력하세요">
	<button type="button" id="idCheck">아이디 확인</button>
	</div>
	<div>
	<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요"> 
	</div>
	<div>
	<input type="text" name="name" id="name" placeholder="이름을 입력하세요">
	</div>
	<div>
	<input type="text" name="age" id="age" placeholder="나이를 입력하세요">
	</div>
	<button type="submit" id="submit" disabled></button>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script>
		$(document).ready(function(){
			
		
		$("#submit").on("click", function(){
			if($("#id").val()==""){
				alert("아이디를 입력해주세요.");
				$("#id").focus();
				return false;
			}
			
			if($("#pw").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#pw").focus();
				return false;
			}
			if($("#name").val()==""){
				alert("이름을 입력해주세요.");
				$("#name").focus();
				return false;
			}
			if($("#age").val()==""){
				alert("나이를 입력해주세요.");
				$("#age").focus();
				return false;
			}
		})
		})
		
		$("#idCheck").click(function(){
		if($("#id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}else{
		var query = {id : $("#id").val()};
 		
		 $.ajax({
		  url : "/sign_up/idCheck",
		  type : "post",
		  data : query,
		  success : function(data) {
		  
		   if(data == 1) {
		     $("#idCheck").text("이미 있는 아이디 입니다.");		     
		   } else {
			   $("#idCheck").text("사용 가능한 아이디 입니다");
		     $("#submit").removeAttr("disabled").text("완료");
		     $("#id").attr("readonly", "readonly");
		   }
		  }
		 });  // ajax 끝
		 } 
});
		
	</script>
</form>
</body>
</html>
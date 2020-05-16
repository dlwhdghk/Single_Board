<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet" />
<meta charset="UTF-8">
<title>로그인 창</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
    <h1>로그인 페이지</h1>
    <form action="sign" method="post">
        <input type="text" name="id" id='id' placeholder="아이디 입력" />
        <br/>
        <input type="password" name="pw" id='pw' placeholder="비밀번호 입력" />
        <br/>
        <input type="submit" id='submit' value="로그인" />
        <br/>
        <input type="hidden" name="target" value="${target}" />        
    </form>
    
    
    <script>
        
        $(document).ready(function(){
        $("#submit").click(function(){	
        if(${member == null}){
        alert("아이디와 비밀번호를 체크해주세요");
        }
        })
        })
        
        </script>
</body>
</html>





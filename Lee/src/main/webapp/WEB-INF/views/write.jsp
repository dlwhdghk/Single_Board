<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = "form1" method="post" action= "/board/write/insert">
	<div>제목
		<input name="board_title" id="title" placeholder="제목을 입력" required="required">
	</div>
	<div>
		<p>내용</p>
		<textarea name="board_context" id = "context" placeholder="내용 입력" rows="15" cols="100" required="required"></textarea>
	</div>
	<div>작성자</div>
		<input type="text" name="board_writer" id="board_writer" value="${member.id}" readonly>
		<button type="submit">완료</button>
		<button onclick="location.href='/board'">취소</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<hr/>
<form action="/join" method="post">
	<input type="text" placeholder="Username" name="username" />
	<input type="password" placeholder="Password" name="password" />
	<input type="email" placeholder="Email" name="email" />
	<button>회원가입</button>
</form>
이미 회원가입이 되셨나요? <a href="/loginForm">로그인</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLTE 2 | Log in</title>
</head>
<body>
<h3>Login Page</h3><hr>
<form action="/user/loginPost" method="post">
	<input type="text" name="userid" placeholder="user ID"><p>
	<input type="password" name="userpw" placeholder="Password"><p>
	<label>
		<input type="checkbox" name="useCookie"> Remember Me
	</label>
	<button type="submit">Sign In</button>
</form>
</body>
</html> 

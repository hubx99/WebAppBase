<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<jsp:useBean id="m" scope="request"
	class="com.example.webapp.web.login.LoginModel"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebAppSample</title>

<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<div>WebAppSample Login</div>
	<div class="message">${message}</div>
	<form method="post">
		<%
			if (m.isMultiTenant()) {
		%>
		<div>
			<input type="text" name="tenant" placeholder="tenant" />
		</div>
		<%
			}
		%>
		<div>
			<input type="text" name="id" placeholder="id" />
		</div>
		<div>
			<input type="password" name="password" placeholder="password"
				autocomplete="off" />
		</div>
		<div>
			<input type="submit" value="login" />
		</div>
	</form>
</body>
</html>
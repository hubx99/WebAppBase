<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
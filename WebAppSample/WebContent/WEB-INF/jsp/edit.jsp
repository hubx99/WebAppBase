<%@page import="com.example.webapp.bean.Item"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.webapp.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<jsp:useBean id="m" scope="request"
	class="com.example.webapp.web.AddModel"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebAppSample</title>
</head>
<body>
	<div>
		<a href="..">cancel</a>
	</div>
	<form method="post">
		<input type="hidden" name="action" value="submit" />
		<table>
			<%
				for (Item i : m.getItems()) {
			%>
			<tr>
				<th><%=i.getLabel()%></th>
				<td><%=i.writeOut(m.getMap())%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			if (!m.getItems().isEmpty()) {
		%>
		<input type="button" value="cancel" /> <input type="submit" />
		<%
			}
		%>
	</form>
</body>
</html>
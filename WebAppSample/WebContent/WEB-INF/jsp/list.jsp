<%@page import="com.example.webapp.bean.Item"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.webapp.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<jsp:useBean id="m" scope="request"
	class="com.example.webapp.web.ListModel"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebAppSample</title>
</head>
<body>
	<div>
		<a href="users/new">new</a> <a href="logout">logout</a>
	</div>
	<div>
		<table>
			<tr>
				<td></td>
				<%
					for (Item i : m.getItems()) {
				%>
				<td><%=i.getLabel()%></td>
				<%
					}
				%>
			</tr>
			<%
				int c = 1;
				for (Map<String, Object> map : m.getList()) {
			%>
			<tr>
				<td><%=c++%></td>
				<%
					for (Item i : m.getItems()) {
				%>
				<td><a href="javascript:edit('<%=map.get(i.getKey())%>')"><%=map.get(i.getKey())%></a></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
	</div>

	<form id="xform" method="post" action="users/edit">
		<input id="xform_id" name="id" type="hidden" />
	</form>

	<script>
		function edit(id) {
			document.getElementById("xform_id").value = id;
			document.getElementById("xform").submit();
		}
	</script>
</body>
</html>
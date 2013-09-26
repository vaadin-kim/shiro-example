<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="org.apache.shiro.SecurityUtils"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<shiro:user>
	<jsp:forward page="${pageContext.request.contextPath}" />
</shiro:user>
<html>
<body>

	<shiro:guest>
		<p>Try logging in using the username "demo" with the password
			"demo"</p>
	</shiro:guest>

	<form method="POST" action="">

		Username: <input type="text" name="username" /> <br /> Password: <input
			type="password" name="password" /><br /> <input type="submit"
			value="Log in" />

	</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2 class="p-3 mb-2 bg-info text-white ">Login page</h2>

	<div class="container">
		<h2>${SPRING_SECURITY_LAST_EXCEPTION.message}</h2>
		<form:form action="login" method="post">
			<div class="form-group">
				<c:if test="${param.error != null }">
					<i>Sorry Invalid email and password password </i>
				</c:if>
				<label>Email address:</label> <input type="text" name="username"
					class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					name="password" class="form-control" id="password"> <label>Remember
					me</label> <input type="checkbox" name="remember-me" id="remember-me" />
			</div>
			<input type="submit" value="login">
			<br>
			<br>
			<!--   <a class = "btn btn-primary" href="/oauth2/authorization/google">Login With Google</a><br><br>
  <a class = "btn btn-primary" href="/oauth2/authorization/facebook">Login With Facebook</a> -->

		</form:form>


		<h2>${msgUserRegister}</h2>
		<br>

		<h4>If new User then SignUp</h4>
		<a href="/showreg">SignUp</a>
	</div>
</body>
</html>
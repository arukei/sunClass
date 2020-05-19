<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>KimSchool Login</title>
</head>
<body style="background-color: #f0f5f3">


	<h1>KimSchool Login</h1>
		<form action="logincheck">
				Id : <input type="text" name="id" required="required"><br>

				Password : <input type="password" name="password" required="required"><br><br>
			
				<input type="submit" value="Login">
				<input type="reset" name="reset" value="Reset" />
		</form>

	<a href="/">뒤로 가기</a><br>
	
	${msg }
</body>
</html>

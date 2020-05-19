<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Write Board Content</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>Write Board Content</h1>
	${id }
	<form action="writeBoard" method="post">
	<input type="hidden" name="id" value="${user.id }">
	Title : <br>
	<input type="text" maxlength="100" placeholder="100자 이내" name="title" required="required"><br>
	Content : <br>
	<input type="text" maxlength="1000" placeholder="1000자 이내" name="content" required="required"	><br>
	<input type="submit" value="등록하기">
	</form>

	<br>


	<a href="./listPage"> 목록으로 돌아가기</a>

</body>
</html>

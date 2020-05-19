<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Modify Page</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>Modify Page</h1>

	<form action="moduserinfo" method="post">
		<table>
			<tr>
				<td align="center">Id :</td>
				<td><input type="text" name="id" value=${user.id }
					readonly="readonly"></td>
			</tr>
			<tr>
				<td align="center">Password :</td>
				<td><input type="password" name="password"
					placeholder=${user.password } required="required"></td>
			</tr>
			<tr>
				<td align="center">Nickname :</td>
				<td><input type="text" name="nickname"
					placeholder=${user.nickname } required="required"></td>
			</tr>
			<tr>
				<td align="center">Email :</td>
				<td><input type="text" name="email" placeholder=${user.email }
					required="required"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수정하기"> <input
					type="reset" name="reset" value="초기화" /></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="./listPage"> 목록으로 돌아가기</a>
	<a href="deleteUserInfo?id=${user.id }">탈퇴하기</a>
	<a href="getMyBoardList?id=${user.id }">내가 쓴 글 보기</a>
</body>
</html>

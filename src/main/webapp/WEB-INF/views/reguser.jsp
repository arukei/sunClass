<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>RegUser</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>RegUser</h1>
	

	<form action="reguser" method="post">
		<table>
			<tr>
				<td align="center">Id :</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td align="center">Password :</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td align="center">Email :</td>
				<td><input type="text" name="emailId" required="required">
				@ <select name="emailAddress" required="required">
					<option value="naver.com">네이버</option>
					<option value="gmail.com">G메일</option>
					<option value="hotmail.com">핫메일</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="center">Nickname :</td>
				<td><input type="text" name="nickname" required="required"></td>
			</tr>
			<tr>
				<td align="center">Gender :</td>
				<td><input type="radio" id="male" name="gender" value="male">
						<label for="male">Male</label><br>
  					<input type="radio" id="female" name="gender" value="female">
  						<label for="female">Female</label><br></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="가입하기">
				<input type="reset" name="reset" value="초기화" /></td>
			</tr>
		</table>
		<a href="/">뒤로 가기</a>
	</form>
</body>
</html>

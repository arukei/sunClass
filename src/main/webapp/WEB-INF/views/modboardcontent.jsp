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

	<form action="modBoardContentAcion" method="post">
		<table>
			<tr>
				<td align="center">No :</td>
				<td><input type="text" name="no" value=${modBoardContent.no }
					readonly="readonly"></td>
			</tr>
			<tr>
				<td align="center">ID :</td>
				<td><input type="text" name="id" placeholder=${modBoardContent.id }
					readonly="readonly"></td>
			</tr>
			<tr>
				<td align="center">Title :</td>
				<td><input type="text" name="title"
					placeholder=${modBoardContent.title } required="required"></td>
			</tr>
			<tr>
				<td align="center">content :</td>
				<td><input type="text" name="content"
					placeholder=${modBoardContent.content } required="required"></td>
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
</body>
</html>

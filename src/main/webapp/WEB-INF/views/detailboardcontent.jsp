<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Detail Board Content</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>Detail Board Content</h1>
	<table border="1">
		<tr>
			<th colspan="4">${boardContent.no }번게시글 내용</th>
		</tr>
		<tr>
			<td>Titie :</td>
			<td colspan="3">${boardContent.title }</td>
		</tr>
		<tr>
			<td>Content :</td>
			<td colspan="3">${boardContent.content }</td>
		</tr>
		<tr>
			<td>작성자 :</td>
			<td colspan="3">${boardContent.id }</td>
		</tr>
		<tr>
			<td>등록날짜 :</td>
			<td colspan="3">${boardContent.reg_date }</td>
		</tr>
		<tr>
			<td>Content :</td>
			<td colspan="3">${boardContent.content }</td>
		</tr>
		<tr>
			<td>조회수 :</td>
			<td colspan="3">${boardContent.view_cnt }</td>
		</tr>

	</table>
	<br>


	<a href="./listPage"> 목록으로 돌아가기</a>
	<c:choose>
		<c:when test="${user.id eq boardContent.id }">
			<a href="modBoardContent?no=${boardContent.no }">글 수정하기</a>
		</c:when>
	</c:choose>

</body>
</html>

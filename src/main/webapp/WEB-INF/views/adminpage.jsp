<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>관리자페이지</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>관리자 ${user.nickname }님 환영합니다</h1>

	<table border="1">
	<tr>
		<th colspan="8">회원관리</th>
	</tr>
		<tr>
			<th>ID</th>
			<th>NICKNAME</th>
			<th>GENDER</th>
			<th>AUTH</th>
			<th>REG_DATE</th>
			<th>등업</th>
			<th>강등</th>
			<th>추방</th>
		</tr>
		
			<!-- 회원정보가 없는 경우에는 데이터가 없습니다 출력 -->
		<c:choose>
			<c:when test="${empty usersList }">
				<tr>
					<td colspan="8" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty usersList}"> 
				<c:forEach items="${usersList}" var="userInfo">
					<tr>
						<td align="center">${userInfo.id }</td>
						<td align="center">${userInfo.nickname }</td>
						<td align="center">${userInfo.gender }</td>
						<td align="center">${userInfo.auth }</td>
						<td align="center">${userInfo.reg_date }</td>
						<td align="center"><a href="upGradeAuth?id=${userInfo.id }">등업</a></td>
						<td align="center"><a href="downGradeAuth?id=${userInfo.id }">강등</a></td>
						<td align="center"><a href="deleteUserInfo?id=${userInfo.id }">추방</a></td>
					</tr>
					</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<br><a href="./listPage"> 목록으로 돌아가기</a>


</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body style="background-color: #f0f5f3">

	<h1>${user.nickname }님 환영합니다</h1>
	<a href="logout">로그아웃</a>
	<a href="movemoduserinfo?id=${user.id }">${user.id }님 정보 수정하기</a><br>
	
	<!-- 권한이 2이면 회원관리버튼 표시 -->
	<c:choose>
		<c:when test="${user.auth eq 2 }">
			<a href="adminpage"> 회원관리</a>
		</c:when>
	</c:choose>

	<table border="1">
		<tr>
			<th>No</th>
			<th>Title</th>
			<th>Id</th>
			<th>Reg_Date</th>
			<th>View_Cnt</th>
		</tr>
		
			<!-- 게시판정보가 없는 경우에는 데이터가 없습니다 출력 -->
		<c:choose>
			<c:when test="${empty boardList }">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${!empty boardList}">
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.no }</td>
						<td><a href="getBoardContent?title=${board.title }">${board.title }</a></td>
						<td>${board.id }</td>
						<td>${board.reg_date }</td>
						<td>${board.view_cnt }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<!-- 권한이 1이면 글쓰기버튼 표시 -->
	<c:choose>
		<c:when test="${user.auth >= 1 }">
			<a href="movewriteboard">글쓰기</a>
		</c:when>
	</c:choose>


</body>
</html>

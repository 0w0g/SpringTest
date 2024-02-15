<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/member/list.jsp</h1>
<table border=1>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입날짜</td>
		<td>수정날짜</td>
	</tr>
<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.userid }</td>
		<td>${list.userpw }</td>
		<td>${list.username}</td>
		<td>${list.useremail }</td>
		<td>${list.regdate }</td>
		<td>${list.updatedate }</td>
	</tr>
</c:forEach>
</table>

<a href="/member/main">메인페이지</a>
</body>
</html>
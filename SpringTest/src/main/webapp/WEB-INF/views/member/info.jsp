<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>

	<h3>아이디 : ${member.userid } </h3>
	<h3>비밀번호 : ${member.userpw } </h3>
	<h3>이름 : ${member.username } </h3>
	<h3>이메일 : ${member.useremail } </h3>
	<h3>가입날짜 : ${fn:replace(fn:substring(member.regdate,0,10),'-','.') } </h3>
	
	<a href="/member/main">메인페이지</a>
			
</body>
</html>
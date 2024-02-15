<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<fieldset>
		<legend>회원수정</legend>
		<!-- action 속성의 값이 없는 경우 : 자기자신의 주소를 호출 -->
		<form action="" method="post">
			아이디 : <input type="text" name="userid" value="${member.userid }" readonly> <br>
			비밀번호 : <input type="text" name="userpw"> <br>
			이름 : <input type="text" name="username" value="${member.username }"> <br>
			이메일 : <input type="email" name="useremail" value="${member.useremail }" readonly> <br>	
			<input type="submit" value="회원수정">	
		</form>		
	</fieldset>
</body>
</html>
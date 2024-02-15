<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<script>
var msg = "${msg}";
if(msg != ""){
	alert(msg);
}

$(document).ready(function () {
	$("#login").click(function (){
		if(userid.value == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if(userpw.value == ""){
			alert("비밀번호를 입력해주세요.")
			return false;
		}
	})
})


</script>

	
	<fieldset>
		<legend>회원 로그인</legend>
		<form action="" method="post">
			아이디 : <input type="text" name="userid" id="userid"><br>
			비밀번호 : <input type="text" name="userpw" id="userpw"><br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" id="login" onclick="location.href='/member/join'">
		</form>
	</fieldset>

</body>
</html>
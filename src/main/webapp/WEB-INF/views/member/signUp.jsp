<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		document.getElementById("insertMemberForm").submit();
	}
</script>
</head>
<body>
	<form action="insertMember" method="post" id="insertMemberForm">
		아이디 : <input type="text" name="customerId"><br>
		패스워드 : <input type="text" name="customerPw"><br>
		이름 : <input type="text" name="name"><br>
		핸드폰번호 : <input type="text" name="phone"><br>
		생년월일 : <input type="text" name="birthdate"><br>
		주소 : <input type="text" name="address"><br>
		<input type="button" value="가입하기" onclick="check()">
	</form>
</body>
</html>

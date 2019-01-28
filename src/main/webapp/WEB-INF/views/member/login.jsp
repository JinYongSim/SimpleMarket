<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		document.getElementById("loginMemberForm").submit();
	}
</script>
</head>
<body>
	<form action="loginMember" id=loginMemberForm>
		아이디 : <input type="text" name="customerId">
		패스워드 : <input type="text" name="customerPw">
		<input type="button" value="로그인" onclick="check()">
	</form>
</body>
</html>
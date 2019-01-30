<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginId==null }">
		<form action="signUp">
			<input type="submit" value="회원가입">
		</form>
		<form action="login">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	<c:if test="${sessionScope.loginId!=null }">
		<form action="logout">
			<input type="submit" value="로그아웃">
		</form>
	</c:if>
	<form action="productList">
		<input type="submit" value="상품보기">
	</form>
	<form action="purchaseList">
		<input type="submit" value="구매내역">
	</form>
	
</body>
</html>
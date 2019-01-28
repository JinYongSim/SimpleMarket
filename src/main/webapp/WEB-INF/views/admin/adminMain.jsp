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
	<form action="productMgr">
		<input type="submit" value="상품관리">
	</form>
	<form action="memberMgr">
		<input type="submit" value="회원관리">
	</form>
	<form action="logoutAdmin">
		<input type="submit" value="로그아웃">
	</form>
	<hr>
	
	<table>
		<tr>
			<td>상품명</td>
			<td>수량</td>
			<td>가격</td>
			<td>설명</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.name }</td>		
				<td>${list.quantity }</td>		
				<td>${list.price }</td>		
				<td>${list.comments }</td>		
				<td>${list.indate }</td>
				<td>
					<form  action="updateProduct">
						<input type="hidden" name="productSeq" value="${list.productSeq }">
						<input type="submit" value="수정">
					</form>
				</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>
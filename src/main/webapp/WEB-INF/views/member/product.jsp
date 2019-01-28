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
				<td><a href=selectProductDetail?productSeq=${list.productSeq}>${list.name }</a></td>		
				<td>${list.quantity }</td>		
				<td>${list.price }</td>		
				<td>${list.comments }</td>		
				<td>${list.indate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
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
				<td>가격</td>
				<td>설명</td>
				<td>구입일</td>
				<td>수량</td>
			</tr>
		<c:forEach var="hMap" items="${hMap }">
			<tr>
				<td>${hMap.NAME }</td>
				<td>${hMap.PRICE }</td>
				<td>${hMap.COMMENTS }</td>
				<td>${hMap.INDATE }</td>
				<td>${hMap.QUANTITY }</td>
				<td>${hMap.PRICEALL }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
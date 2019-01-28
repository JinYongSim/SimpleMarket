<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		document.getElementById("insertProductionForm").submit();
	}
</script>
</head>
<body>
	<c:if test="${product==null }">
		<form action="insertProduct" method="post" id="insertProductionForm">
	</c:if>
	<c:if test="${product!=null }">
		<form action="updateContent" method="post" id="insertProductionForm">
		<input type="hidden" name="ProductSeq" value="${product.productSeq }">
	</c:if>
		상품명 : <input type="text" name="name" value="${product.name }" >
		수량 : <input type="text" name="quantity" value="${product.quantity }">
		가격 : <input type="text" name="price" value="${product.price }">
		설명 : <input type="text" name="comments" value="${product.comments }">
		<input type="button" value="등록" onclick="check()">
	</form>
	
		
</body>
</html>

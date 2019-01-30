<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		document.getElementById("buyProductForm").submit();
	}
</script>
</head>
<body>
	<form action="memberMain">
		<input type="submit" value="돌아가기">
	</form>
	<table>
		<tr>
			<td>상품명 : ${product.name }</td>
			<td>가격 : ${product.price }</td>
			<td>재고량 : ${product.quantity }</td>
			<td>설명 : ${product.comments }</td>
			<td>등록일 : ${product.indate }</td>
		</tr>
	</table>
	<hr>
	<form action="buyProduct" id="buyProductForm">
		<input type="hidden" name="productSeq" value="${product.productSeq}">
		<input type="hidden" name="customerId" value="${sessionScope.loginId}">
		구매수량 : <input type="text" name="quantity">
		<input type="button" value="구매하기" onclick="check()">
	</form>
</body>
</html>
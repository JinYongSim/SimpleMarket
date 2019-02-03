<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function submitForm(page){
	document.getElementById("page").value=page;
	document.getElementById("myForm").submit();
}
</script>
</head>
<body>
	<form action="memberMain">
		<input type="submit" value="돌아가기">
	</form>
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
	<a href="javascript:submitForm('${navi.currentPage-1}')">이전페이지</a>
	<c:forEach var="page" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
	
	<c:if test="${navi.currentPage==page}">
	&nbsp;<a href="javascript:submitForm('${page}')"><b>${page}</b></a>&nbsp;
	</c:if>
	
	<c:if test="${navi.currentPage!=page}">
	&nbsp;<a href="javascript:submitForm('${page}')">${page}</a>&nbsp;
	</c:if>
	
	</c:forEach>
	<a href="javascript:submitForm('${navi.currentPage+1}')">다음페이지</a>
	
	<form action="productList" id="myForm">
		<input type="hidden" name="page" id="page" value="${navi.currentPage}">
		검색 : <input type="text" name="search" id="search" value="${search }">
		<input type="submit" value="검색">
	</form>
</body>
</html>
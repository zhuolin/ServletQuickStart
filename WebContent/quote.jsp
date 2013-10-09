<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your quote</title>
<script type="text/javascript" src="js/jquery.tools.min.js?v=20130913"></script>
<script type="text/javascript">
function goback(){
	window.location = 'index.jsp';
}
</script>
<style>
.tblresult tr td{padding-left:5px;padding-right:5px;text-align: center;}
</style>
</head>
<body>
	<h3>Your quote</h3>
	<div class="message">${message}</div>
	<div class="result">
		<table class="tblresult" border="1">
			<tr>
				<td>Domain</td>
				<td>Yearly price</td>
				<td>Loan Years</td>
				<td>Total price</td>
			</tr>
		<c:forEach items="${results}" var="result">
			<tr>
				<td>${result.url}</td>
				<td>${result.product.price}</td>
				<td>${result.years}</td>
				<td>${result.total}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<div class="ordertotal">Your total fee is: ${ordertotal}</div>
	<div>
		<input type="button" value="back" onclick="goback()"/>
	</div>
</body>
</html>
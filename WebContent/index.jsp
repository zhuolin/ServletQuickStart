<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<script type="text/javascript" src="js/jquery.tools.min.js?v=20130913"></script>
<script type="text/javascript" src="js/index.js?v=20130913"></script>
<style>
.domainInput{width:150px;}
.yearsel{width: 70px;padding-left: 15px;}
#btnSubmit{margin-left:30px;}
</style>
</head>
<body>
<h2>Please enter domain</h2>
<form action="getquote" method="post">
<div class="dataarea">
	<table id="datatable">
		<tr>
			<td>domain URL </td>
			<td>Loan Years </td>
		</tr>
		<tr id="datarow">
			<td><input type="text" name="domain" class="domainInput"/></td>
			<td>
				<select class="yearsel" name="year">
				<%for(int i=1;i<11;i++){%>
					<option value="<%=i%>"><%=i%></option>
				<%} %>
				</select>
			</td>
		</tr>
	</table>
	<input type="button" id="addurl" value="add one" name="btnAdd" />
	<input type="submit" value="submit" id="btnSubmit" name="btnSubmit"/>
</div>
</form>
</body>
</html>
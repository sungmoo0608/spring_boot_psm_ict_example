<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emp List</title>
</head>
<body>
	<h1>Emp List</h1>
	<table border="1">
		<tr>
			<td>사원이름</td>
			<td>월급</td>
			<td>등급</td>
		</tr>
		<c:forEach var="emp" items="${empList}">
		<tr>
			<td>${emp.ename}</td>
			<td>${emp.sal}</td>
			<td>${emp.salGrade.grade}</td>
		</tr>
		</c:forEach>
	</table>
	<tr>
    	<td colspan="5"><a href="${pageContext.request.contextPath}/emp/insert_view">입력</a></td>
    </tr> 
   
</body>
</html>
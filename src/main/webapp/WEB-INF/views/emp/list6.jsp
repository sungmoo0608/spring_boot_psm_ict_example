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
			<td>사원번호</td>
			<td>사원이름</td>
			<td>직급</td>
			<td>매니저</td>
			<td>입사일자</td>
			<td>월급</td>
			<td>등급</td>
			
		</tr>
		<c:forEach var="vo" items="${empList}">
		<tr>
			<td>${vo.emp.empno}</td>
			<td>${vo.emp.ename}</td>
			<td>${vo.emp.job}</td>
			<td>${vo.emp.mgr}</td>
			<td>${vo.emp.hiredate}</td>
			<td>${vo.emp.sal}</td>
			<td>${vo.salGrade.grade}</td>
		</tr>
		</c:forEach>
	</table>
	<tr>
    	<td colspan="5"><a href="${pageContext.request.contextPath}/emp/insert_view">입력</a></td>
    </tr> 
   
</body>
</html>
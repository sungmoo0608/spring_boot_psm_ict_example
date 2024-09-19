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
			<td>사원직급</td>
			<td>매니저</td>
			<td>입사일자</td>
			<td>월급</td>
			<td>보너스</td>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서위치</td>
		</tr>
		<c:forEach var="deptEmp" items="${empDeptList}">
		<c:forEach var="emp" items="${deptEmp.empList}">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.mgr}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.sal}</td>
			<td>${emp.comm}</td>
			<td>${emp.deptno}</td>
			<td>${deptEmp.dname}</td>
			<td>${deptEmp.loc}</td>
		</tr>
		</c:forEach>
		</c:forEach>
	</table>
	<tr>
    	<td colspan="5"><a href="${pageContext.request.contextPath}/emp/insert_view">입력</a></td>
    </tr> 
   
</body>
</html>
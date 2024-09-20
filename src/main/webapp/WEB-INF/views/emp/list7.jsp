<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
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
			<th>사원이름</th>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
			<th>월급</th>
			<th>등급</th>
			
		</tr>
		<c:forEach var="vo" items="${empList}">
		<tr>
			<td>${vo.emp.ename}</td>
			<td>${vo.dept.deptno}</td>
			<td>${vo.dept.dname}</td>
			<td>${vo.dept.loc}</td>
			<td><fmt:formatNumber value="${vo.emp.sal}" type="number"/></td>
            <!-- 숫자 1000을 1,000으로 표시하는 태그 -->
			<td>${vo.salGrade.grade}</td>
		</tr>
		</c:forEach>
	</table>
	<tr>
    	<td colspan="5"><a href="${pageContext.request.contextPath}/emp/insert_view">입력</a></td>
    </tr> 
   
</body>
</html>
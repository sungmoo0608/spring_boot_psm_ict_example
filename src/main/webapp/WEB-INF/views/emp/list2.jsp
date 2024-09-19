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
		</tr>
		<c:forEach var="emp" items="${empList}">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.mgr}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.sal}</td>
			<td>${emp.comm}</td>
			<td>${emp.deptno}</td>
		</tr>
		</c:forEach>
	</table>
	<tr>
    	<td colspan="5"><a href="${pageContext.request.contextPath}/emp/insert_view">입력</a></td>
    </tr> 
   
   <c:if test="${pageMaker.prev}">
      <a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }"> << </a>
   </c:if>
   
   <c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
      <a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
   </c:forEach>
   
   
   <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
      <a href="list2${pageMaker.makeQuery(pageMaker.endPage + 1) }"> >> </a>
   </c:if>
   
</body>
</html>
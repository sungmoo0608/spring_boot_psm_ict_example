<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>사원 정보 입력</h1>
   
   <form action="/emp/insert" method="post">
      사번:<input type="text" name="empno"><br>
      이름:<input type="text" name="ename"><br>
      직업:<input type="text" name="job"><br>
      메니저: 
      <select name="mgr">
         <c:forEach var="emp" items="${empList}">
            <option value="${emp.empno}">(${emp.empno})${emp.ename}</option>
         </c:forEach>
      </select><br>
      입사일:<input type="text" name="hiredate2"><br>
      급여:<input type="text" name="sal"><br>
      커미션:<input type="text"name="comm"><br>
      부서:
      <select name="deptno">
         <c:forEach var="dept" items="${deptList}">
            <option value="${dept.deptno}">(${dept.deptno})${dept.dname}</option>
         </c:forEach>
      </select><br>
      <input type="submit" value="전송">
   </form>
   

   
</body>
</html>
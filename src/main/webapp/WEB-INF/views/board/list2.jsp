<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
   <h1>게시판 리스트</h1>
   <table width="500" cellpadding="0" cellspacing="0"  border="1">
      <tr>
         <td>번호</td>
         <td>이름</td>
         <td>제목</td>
         <td>날짜</td>
         <td>히트</td>            
      </tr>
      <c:forEach var="board" items="${boards}">
         <tr>
            <td>${board.bid}</td>
            <td>${board.bname}</td>            
            <td>
               <c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
               <a href="${pageContext.request.contextPath}/board/content_view?bid=${board.bid}">${board.btitle}</a>
            </td>
            <td>${board.bdate}</td>
            <td>${board.bhit}</td>         
         </tr>
      </c:forEach>
      <tr>
         <td colspan="5"><a href="${pageContext.request.contextPath}/board/write_view">글작성</a></td>
      </tr>      
   </table>
   
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
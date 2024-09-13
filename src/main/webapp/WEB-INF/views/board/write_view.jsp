<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
   <h1>글 작성</h1>
   <table width="500" border="1">
      <form action="${pageContext.request.contextPath}/board/write" method="post">
         <tr>
            <td>이름</td>
            <td><input type="text" name="bname" size="50"></td>      
         </tr>
         <tr>
            <td>제목</td>
            <td><input type="text" name="btitle" size="50"></td>      
         </tr>
         <tr>
            <td>내용</td>
            <td><textarea name="bcontent" rows="10"></textarea></td>      
         </tr>
         
         <tr>
            <td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/list">목록보기</a> </td>
         </tr>
      </form>
   </table>

</body>
</html>
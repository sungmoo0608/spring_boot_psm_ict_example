<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/eshopper/js/board.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		let board = boardService();
		//board.list();
		//board.get(1021);
		
		let boardObj = {
			bid : 1171,
			bname : "바밤바5",
			bcontent : "아홓홓아햏햏",
			btitle : "앞으로 읽어도 바밤바"
		};
		
		//board.add(boardObj);
		
		//board.del(1176);
		
		board.modify(boardObj);
		
	});
</script>
 
</head>
<body>
	<h1>Rest 게시판 연습</h1>
	

	
</body>
</html>
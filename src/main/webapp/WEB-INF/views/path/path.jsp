<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 경로 상대 경로 테스트</title>
</head>
<body>
	<h1>절대 경로 상대 경로 테스트</h1>
	
	<h2>상대 경로</h2>
	<img alt="이미지 경로 제대로 넣어라1" src="eshopper/images/404/404.png"><br>
	
	<h2>절대 경로</h2>
	<!-- /spring_boot_psm_ict_example -->
	<img alt="이미지 경로 제대로 넣어라2" src="${pageContext.request.contextPath}/eshopper/images/404/404.png">
</body>
</html>
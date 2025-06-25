<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath }/js/jquery-3.7.1.min.js"></script>
<style>
	h1>a{color: black; text-decoration: none;}
	h1>a:active{color: orangered;}
</style>
</head>
<body>

	<c:set value="${pageContext.servletContext.contextPath }" var="contextPath" scope=appl
	<h1 align="center"><a href="${contextPath }
	
	
	
	<!--  코드 미완성 
		<% include file="WEB-INF/views?common/top.jsp" %>
		<jsp:include page="WEB_INF/views/common/loginbar.jsp"/>;
	-->
	
	
</body>
</html>
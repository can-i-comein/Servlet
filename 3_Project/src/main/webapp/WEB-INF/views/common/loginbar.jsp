<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#Loginbar{text-align: right; margin: 50px;}
	#Loginbar>a{color: black; text-decoration: none;}
	#Loginbar>a:hover{font-weight: bold; text-decoration: underline;}
</style>
</head>
<body>
	<div id="Loginbar">
		<c:if test="${empty loginUser }">
			<a href="${contextPath }/LoginView.me">로그인</a>
		</c:if>
		<c:if test="${!empty loginUser }">
			<b>${loginUser.empName }님, 반갑습니다.</b><br/><br/>
			<a href="${contextPath }/editPage.me">내정보수정</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${contextPath }/Logout.me">로그아웃</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
	

		<a href="${contextPath }/LoginView.me">로그인</a>
	</div>
</body>
</html>
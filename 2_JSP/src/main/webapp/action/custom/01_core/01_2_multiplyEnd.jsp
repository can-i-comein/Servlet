<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:set 태그</h2> 
	<!-- 변수 선언 -->
	<c:set var="no1" value="${ param.num1 }"/>
	<c:set var="no2" value="${ param.num2 }"/>
	<c:set var="result" value="${ no1 * no2 }"/>
	<p>${no1} 곱하기 ${no2} 값은 ${result}입니다.</p>
	
	<hr/>
	
	<h2>c:remove 태그</h2>
	<p>지정한 변수를 모든 scope에서 검색해 삭제하거나 지정한 scope에서만 삭제</p>
	<c:set var="result" value="9999" scope="request"/>
	삭제 전 result : ${result} <br/> <!-- 30 -->
	삭제 전 requestScope.result : ${requestScope.result} <br/> <!-- 9999 -->
	
	<br/>
	
	<c:remove var="result" scope="request"/>
	삭제 후 result : ${result} <br/> <!-- 30 -->
	삭제 후 requestScope.result : ${requestScope.result} <br/> <!-- 결과없음 -->
	
	+
	<c:remove var="result" scope="page"/>
	삭제 후 result : ${result} <br/> <!-- 9999 -->
	삭제 후 requestScope.result : ${requestScope.result} <br/> <!-- 9999 -->
	
	
</body>
</html>
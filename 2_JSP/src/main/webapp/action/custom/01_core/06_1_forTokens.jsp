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
	<c:set car="family1" value="신형만, 봉미선, 신짱구, 신짱아"/>
	<ul>
		<c:forTokens items="${ family1 }" delims=", ">
			<li>${ f1 }</li>
		</c:forTokens>
	</ul>
	
	<c:set car="family2" value="신형만, 봉미선, 신짱구, 신짱아/둘리, 또치-도우너.희동!길동"/>
	<ul>
		<c:forTokens items="${ family2 }" delims=",/-.!" var="f2">
			<li>${ f2 }</li>
		</c:forTokens>
	</ul>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="123456789"/><br/>
	<fmt:formatNumber value="123456789" groupingUsed="false"/><br/>
	<fmt:formatNumber value="1.234567"/><br/>
	<fmt:formatNumber value="1.234567" pattern="#.##"/><br/>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br/>
	<fmt:formatNumber value="1.2" pattern="#.00"/><br/>
	<fmt:formatNumber value="0.12" type="percent"/><br/>
	<fmt:formatNumber value="123456789" type="currency"/><br/>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br/>
	
</body>
</html>
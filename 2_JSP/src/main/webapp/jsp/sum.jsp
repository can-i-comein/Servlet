<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.io.File"
    errorPage="error/errorPage.jsp"
%>
<%@ page import="java.sql.Connection" %>
<%-- 
	page 지시어 : JSP페이지를 처리하는데 필요한 각종 속성을 기술하는 부분
		language : 사용할 스크립트 언어
		contentType : 웹 브라우저가 받아볼 페이지 인코딩 방식
		pageEncoding : JSP파일에 쓰이는 소스코드 자체 인코딩 방식
		import == java import
		errorPage : 현재 페이지에서 오류가 났을 떄 호출할 페이지 지정
		isErrorPage : 오류 처리 파일로 사용할 때 사용, true면 exception객체 사용 가능
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML -->
	<%-- JSP주석 --%>
	
	<%
		int total = 0;
		for(int i = 1; i <= 10; i++){
	%>
			<h1>하이하이</h1>
	<%	
			total += i;
		}
		
		
	ArrayList<String> list = new ArrayList<String>();
	File f = null;
	Connection conn = null;
	list.add(null);
	list.get(0).charAt(0);
	
	
	
	
	%>
	
	
	
	
	
	
	
	expression 출력 : 1부터 10까지의 합은 <%= total %>입니다.<br/>
	scriptlet 출력 : 1부터 10까지의 합 <% out.println(total); %>입니다.<br/>
	
	
	
	
	
	
	
	
	
</body>
</html>
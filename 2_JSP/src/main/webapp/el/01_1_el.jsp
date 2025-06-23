<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/myEl.do" method="post">
	
		<h2>개인정보 입력</h2>
		이름 : <input type="text" name="name" id="name"><br/>
		성별 : <input type="radio" name="gender" value="남">남자
		      <input type="radio" name="gender" value="여">여자<br/>
		나이 : <input type="number" name="age"/>
		
		<hr/>
		
		<h2>당신이 가장 좋아하는 는?</h2>
		당신이 가장 좋아하는 음료는? <input type="text" name="beverage"/><br/>
		당신이 가장 좋아하는 물건1은? <input type="text" name="product"/><br/>
		당신이 가장 좋아하는 물건2는? <input type="text" name="product"/><br/>
		당신이 가장 좋아하는 물건3은? <input type="text" name="product"/><br/>
		당신이 가장 좋아하는 책은? <input type="text" name="book"/><br/>
		당신이 가장 좋아하는 영화는? <input type="text" name="movie"/><br/>
		
		<br/>
		
		<input type="submit" value="전송"/>
		
		<hr/>
		
		<form action="01_2_elEnd.jsp">
			<input type="text" name="name" placeholder="제품명을 입력하세요"/><br/>
			<input type="number" name="count" placeholder="수량을 입력하세요"/><br/>
			<input type="text" name="option" placeholder="옵션1"/><br/>
			<input type="text" name="option" placeholder="옵션2"/><br/>
			<input type="submit" value="제출"/><br/>
			
		</form>
		
	</form>
</body>
</html>
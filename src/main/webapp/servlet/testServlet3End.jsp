<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String gender = (String)request.getAttribute("gender");
	String food = (String)request.getAttribute("foods");
	String recommendation = (String)request.getAttribute("recomm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{color:red;}
	span{font-weight: bold;}
	.name{color: orange;}
	.gender{color: yellow; background: black;}
	.age{color: green;}
	.city{color: blue;}
	.height{color: navy;}
	.food{color: purple;}
</style>
</head>
<body>
	<h2>개인취향 테스트 결과 - GET</h2>
		<span class='name'><%= name %></span>님은
		<span class='age'><%= age %></span>이시며, ", age
		<span class='city'><%= city %></span>에 사는 키 <span class='height'><%= height %></span>cm인 " ,city, height
		<span class='gender'><%= gender %></span>입니다. 
		좋아하는 음식은 <span class='food'><%= food %></span>입니다.
		if(food != null) {
			for(int i = 0 ; i < food.length; i++) {
				if(i == 0) {
					out.printf("%s", food[i]);
				} else {
					out.printf(", %s", food[i]);
				}
			}
		}
		</span>입니다.
		<hr/>
		<h3><%= age %>에 맞는 선물 추천</h3>
		'<%= recommendation %>' 선물은 어떠신가요?

</body>
</html>
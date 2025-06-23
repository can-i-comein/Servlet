package com.kh.servlet;

import java.util.Arrays;

public class TestServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) thorws ServletException, IOException{
		//System.out.println("잘 들어왔니?");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String food = request.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		System.out.println(Arrays.toString(food));
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWirter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("span{font-weight: bold;}");
		out.println(".name{color: orange;}");
		out.println(".gender{color: yellow; background: black;}");
		out.println(".age{color: green;}");
		out.println(".city{color: blue;}");
		out.println(".height{color: navy;}");
		out.println(".food{color: purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인취향 테스트 결과 - GET</h2>");
		out.println("<span class='name'>" + name + "</span>님은 ");
		out.println("<span class='age>%s</span>이시며, ", age);
		out.println("<span class='city>%s</span>에 사는 키 <span class='height>%s</span>cm인 " ,city, height);
		out.println("<span class='gender'>%s</span>입니다. 좋아하는 음식은 <span class='food'>", gender);
		if(food != null) {
			for(int i = 0 ; i < food.length; i++) {
				if(i == 0) {
					out.printf("%s", food[i]);
				} else {
					out.printf(", %s", food[i]);
				}
			}
		}
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");
		
	}
}

package com.kh.servlet;

public class TestServlet3 extends HttpServlet{
	// servlet mapping
	// servlet으로 잘 들어왔는지 확인 후 보낸 데이터 찍어보기
	
	//doPost 오버라이딩
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) thorws ServletException, IOException{
		request.setCharacterEncoding("UTF-8"); // 한글 안깨지게 하는 설정 원래는 해야되나 톰캣버전이 좋아져서 안해도됨

		
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
	
		String recommendation = null;
		switch(age) {
		case "10대 미만": recommendation = "사탕"; break;
		case "10대": recommendation = "문화상품권"; break;
		case "20대": recommendation = "향수"; break;
		case "30대": recommendation = "지갑"; break;
		case "40대": recommendation = "양주"; break;
		case "50대": recommendation = "임영웅 콘서트 티켓"; break;
		}
		
		requset.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", String.join(", " , food));
		request.setAttribute("recomm", recommendation);
		
		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet3End.jsp");
		
}

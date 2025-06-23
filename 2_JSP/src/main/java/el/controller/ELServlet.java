package el.controller;

public class ELServlet extends HttpServlet {
	
	String name = request.getParameter("name");
	char gender = request.getParameter("gender").charAt(0);
	int age = Integer.parseInt(request.getParameter("age"));
	Person p = new Person(name, gender, age);
	
	String[] products = request.getParameterValues("product");
	String book = request.getParameter("book");
	String movie = request.getParameter("movie");
	String beverage = request.getParameter("beverage");
	
	request.setAttribute("person", p);
	request.setAttribute("beverage", beverage);
	request.setAttribute("year", 2025);
	request.setAttribute("products", products);
	
	HttpSession session = request.getSession();
	session.setAttribute("book", book);
	
	ServletContext application = request.getServletContext();
	application.setAttribute("movie", movie);
	
	RequestDispatcher view = request.getRequestDispatcher("el/01_2_elEnd.jsp");
	view.forward(request, response);
	
	
}

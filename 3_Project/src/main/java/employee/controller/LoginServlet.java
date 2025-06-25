package employee.controller;

import java.io.IOException;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me") // 데이터 받아서 DB접근 있는지 없는지 확인 있으면 뿌리고 없으면 잘못됐다고 출력
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		
		Employee e = new Employee();
		e.setEmpNo(id);
		e.setPwd(pwd);
		
		// 있냐 없냐 (boolean, count)로는 이름과 정보를 가져올 수 없음
		EmployeeService eService = new EmployeeService();
		Employee login = eService.login(e);
		
		// System.out.println(login);
		
		/*
					forward		  vs		sendRedirect
						view로 이동해주는 메소드
			request, response 유지  /	request, response 새로 생성
			-> 담은 데이터 유지				-> 담은 데이터 유지 x
			-> 전달할 데이터가 있을 때		-> 전달할 데이터가 없을 떄
			
			요청했었던 url 유지				새롭게 지정한 url로 변경
		 */
		
		if(login != null) {
			// 로그인 정보 있을 때
			HttpSession session = request.getSession(); 
			session.setAttribute("loginUser", login);
			session.setMaxInactiveInterval(600); // 10분
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()); // index.jsp -> request.getContextPath() : url을 숨기기 위해
			// sendRedirect에 담았지만 로그인 정보가 유지되는 이유는 session에 담았기 때문이다.
			
		} else {
			// 로그인 정보 없을 때
			request.setAttribute("msg", "로그인을 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
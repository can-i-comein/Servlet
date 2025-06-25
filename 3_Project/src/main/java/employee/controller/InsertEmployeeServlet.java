package employee.controller;

import java.io.IOException;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEmployeeServlet
 */
@WebServlet("/insertEmp.me")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 인코딩
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		Integer mgr = request.getParameter("mgr").indexOf("-") == 0
						? null : Integer.parseInt(request.getParameter("mgr"));
		// int값을 Integer을 사용하는 이유는 null 때문
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptNo = Integer.parseInt(request.getParameter("dept"));
		String isAdmin = request.getParameter("isAdmin") == null ? "N" : "Y";
		
		Employee e = new Employee(id, null, name, job, mgr, null, null, sal, comm, deptNo, null, isAdmin, null);
		
		int result = new EmployeeService().insertEmployee(e);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/admin.me?afterEnroll=Y");
			// ? 물음표를 붙이는 것의 의미는
		} else {
			request.setAttribute("msg", "사원등록을 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		System.out.println(isAdmin);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

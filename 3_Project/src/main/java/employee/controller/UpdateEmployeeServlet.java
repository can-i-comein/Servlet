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
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmp.me")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String job = request.getParameter("job");
				int sal = Integer.parseInt(request.getParameter("sal"));
				int comm = request.getParameter("comm").equals("")? 0 : Integer.parseInt(request.getParameter("comm"));
				int deptNo = Integer.parseInt(request.getParameter("deptNo"));
	
				/*
					비밀번호 수정 하는 경우 (pwd가 수정할 값으로 들어가있음)
						update emp
						set pwd = ?, name = ?, job = ?, sal = ?, comm = ?, deptno = ?
						where emp=? ==> 위치홀더 7개
						
					비밀번호 수정하지 않는 경우 (pwd가 ""로 들어가있음)
						update emp
						set name = ?, job = ?, sal = ?, comm = ?, deptno = ?
						where emp=? ==> 위치홀더 6개
				*/
				HttpSession session = request.getSession();
				if(pwd.equals("")) {
					pwd = ((Employee)session.getAttribute("loginUser")).getPwd();
				}
				
				Employee e = new Employee(id, pwd, name, job, null, null, null, sal, comm, deptNo, null, null, null);
				
//				Service -> DAO -> DB(update)
//				Controller까지 update결과값을 가지고 와서 
//				해당 결과값으로 view 결정
//				성공 시 : 내 정보 수정 페이지로
//				실패 시 : 에러 페이지
				
				EmployeeService eService = new EmployeeService();
				int result = eService.updateEmployee(e);
				if(result > 0) {
					Employee updateEmp = eService.login(e);
					session.setAttribute("loginUser", updateEmp);
					session.setMaxInactiveInterval(600);
					// request.sendRedirect(request.getContextPath() + "/editPage.me");
					request.sendRedirect(request.getContextPath());
				} else {
					request.setAttribute("msg", "정보수정을 실패했습니다.");
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

package employee.model.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import employee.model.dao.EmployeeDAO;
import employee.model.vo.Employee;

public class EmployeeService {

	private EmployeeDAO dao = new EmployeeDAO();
	
	public Employee login(Employee e) {
		Connection conn = getConnection();
		Employee login = empDAO.login(conn, e);
		
		
		return login;
	}

	public ArrayList<Employee> selectAll() {
		Connection conn = getConnection();
		ArrayList<Employee> list = empDAO.selectAll(conn);
		
		return list;
	}

	public int insertEmployee(Employee e) {
		Connection conn = getConnection();
		int result = empDAO.insertEmployee(conn, e);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int updateEmployee(Employee e) {
		Connection conn = getConnection();
		int result = empDAO.updateEmployee(conn, e);
		if(result > 0) {
		// 미완성 코드	
		}

		return result;
	}

	public int checkEmpNo(Connection conn, int empNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "select count(*) from emp where empno = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
}

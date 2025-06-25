package employee.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employee.model.vo.Employee;

public class EmployeeDAO {

	public Employee login(Connection conn, Employee e) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Employee login = null;
		
		String query = "select * from v_selectemp where empno = ? and pwd = ? and status = 'Y'";
		// 필드 개수와 오라클 컬럼 개수가 다른 이유는 실제 조회할 때 이름을 보고 싶기 때문(부서명, 매니저명)
		// vo는 무조건 테이블 구성과 똑같이 간다 -> 틀릴 수도 있음
		// 뷰를 사용해서 쿼리 길이 축소
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  e.getEmpNo());
			pstmt.setString(2, e.getPwd());
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				login = new Employee(rset.getInt("empno"),
									 rset.getString("pwd"),
									 rset.getString("ename"),
									 rset.getString("job"),
									 rset.getInt("mgr_no"),
									 rset.getString("mgr"),
									 rset.getDate("hiredate"),
									 rset.getInt("sal"),
									 rset.getInt("comm"),
									 rset.getInt("deptno"),
									 rset.getString("dname"),
									 rset.getString("is_admin"),
									 rset.getString("status"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return login;
	}
	
//	public ArrayList<Employee> selectAll(Connection conn){
//		Statement stmt = null;
//		ResultSet rset = null;
//		ArrayList<Employee> list = new ArrayList<Employee>();
//		
//		String query = "select * from v_selectemp";
//		
//		try {
//			stmt= conn.createStatement();
//			rset = stmt.executeQuery(query);
//			while(rset.next()) {
//				list.add(new Employee(rset.getInt("empno"),
//									 rset.getString("pwd"),
//									 rset.getString("ename"),
//									 rset.getString("job"),
//									 rset.getInt("mgr_no"),
//									 rset.getString("mgr"),
//									 rset.getDate("hiredate"),
//									 rset.getInt("sal"),
//									 rset.getInt("comm"),
//									 rset.getInt("deptno"),
//									 rset.getString("dname"),
//									 rset.getString("is_admin"),
//									 rset.getString("status"));
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} finally {
//			close(rset);
//			close(stmt);
//		}
//		
//		return list;
//		
//	}
//	
//	
//	public int inserEmployee(Connection conn, Employee e) {
//		// insert는 데이터베이스 컬럼명 참조
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query = "insert into emp values(?,?,?, " + e.getMgrNo() + ", sysdate, ?, ?, ?, default, ?, default)";
//		// null을 위치홀더 값에 넣을 수 없다. 그냥 생null은 넣을 수 있다.
//	
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, e.getEmpNo());
//			pstmt.setString(2, e.getEmpName());
//			pstmt.setString(3, e.getJob());
//			pstmt.setInt(4, e.getSal());
//			pstmt.setInt(5, e.getComm());
//			pstmt.setInt(6, e.getDeptNo());
//			pstmt.setString(7, e.getIsAdmin());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch(SQLException e1) {
//			e1.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//	
//		return result;
//		
//	}
//		
//		public int updateEmployee(Connection conn, Employee e) {
//			PreparedStatement pstmt = null;
//			int result = 0;
//			
//			String query = "update emp set pwd=?, ename=?, job=?, sal=?, comm=?, deptno=?, where empno=?";
//			try {
//				pstmt = conn.prepareStatement(query);
//				pstmt.setString(1, e.getPwd());
//				pstmt.setString(2, e.getEmpName());
//				pstmt.setString(3, e.getJob());
//				pstmt.setString(4, e.getSal());
//				pstmt.setString(5, e.getComm());
//				pstmt.setString(6, e.get());
//				pstmt.setString(7, e.get()); // 미완성
//				
//				result = pstmt.executeUpdate();
//				
//			} catch(SQLException e1) {
//				e1.printStackTrace();
//			} finally {
//				close(pstmt);
//			}
//			
//			return result;
//		}
//		
//		public int updateState(Connection conn, int id, String col, String value) {
//			PreparedStatement pstmt = null;
//			int result = 0;
//			
//			String query = "update emp set " + "=? where empno=?";
//			
//			try {
//				pstmt = conn.prepareStatement(query);
//				pstmt.setString(1, value);
//				pstmt.setInt(2, id);
//				result = pstmt.executeUpdate();
//			} catch(SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close(pstmt);
//			}
//			
//			return result;
//		}
//	
//	}

}
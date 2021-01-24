package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String password = request.getParameter("PWD");
		//지금 부터 DB연동(1.JDBC 2.MyBatis)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null; PreparedStatement pstmt = null;
		String select = "select password from remember_jaegu where id=?";
		ResultSet rs = null; String result = "";//조회결과를 위한 변수
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회된 결과로 이동이 되면 결과 존재
				String pwd = rs.getString(1);
				if(pwd.equals(password)) {//암호가 일치하는 경우,로그인성공
					HttpSession session = request.getSession();
					session.setAttribute("LOGIN", id);
					result = "OK";
				}else {//계정은 있으나 암호가 일치하지 않는 경우
					result = "NOPWD";
				}
			}else {//조회된 결과로 이동이 안되는 경우
				result = "NOID";
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		//페이지 전환(loginResult.jsp), Redirect? Forward?
		response.sendRedirect(
				"template.jsp?BODY=loginResult.jsp?R="+result);
	}

}
















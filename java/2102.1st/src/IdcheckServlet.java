package idcheck;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;

/**
 * Servlet implementation class IdcheckServlet
 */
@WebServlet("/idCheck.do")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("USER_ID");
		Crud crud = new Crud();
		String dup = crud.selectId(id);//DB에서 입력된 계정을 검색
		request.setAttribute("ID", id);//입력된 계정을 저장
		request.setAttribute("DUP", dup);//검색된 결과를 저장
		RequestDispatcher rd = request.getRequestDispatcher("idCheck.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}







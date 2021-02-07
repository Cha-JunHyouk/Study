package util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatjipServlet
 */
@WebServlet("/matjip")
public class MatjipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatjipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String town = request.getParameter("TOWN");
		//입력된 동네에 맛집을 찾는 객체를 만든다.(MatjipExpert)
		MatjipExpert me = new MatjipExpert();
		ArrayList<String> result = me.getNames(town);
		//페이지 전환(matjipResult.jsp)
		//1.Redirect, 2.Forward
		request.setAttribute("RESULT", result);
		RequestDispatcher rd = request.getRequestDispatcher("matjipResult.jsp");
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








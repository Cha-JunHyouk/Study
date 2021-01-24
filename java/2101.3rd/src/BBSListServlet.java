package bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.BBS;

/**
 * Servlet implementation class BBSListServlet
 */
@WebServlet("/bbsList.do")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//remember_bbs에서 모든 게시글을 검색
		Crud crud = new Crud();
		List<BBS> bbsList = crud.getAllBBS();
		//검색한 결과를 jsp(bbsList.jsp)로 전송, Redirect? Forward?
		request.setAttribute("BBSLIST", bbsList);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsList.jsp");
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














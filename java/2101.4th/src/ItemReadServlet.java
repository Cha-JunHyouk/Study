package item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Item;

/**
 * Servlet implementation class ItemReadServlet
 */
@WebServlet("/itemRead.do")
public class ItemReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("PID");
		//DB에서 pid를 상품번호로 하는 상품을 검색
		Crud crud = new Crud();
		Item item = crud.getItem(Integer.parseInt(pid));
		request.setAttribute("ITEM", item);
		//검색결과를 JSP(itemRead.jsp)로 전달
		RequestDispatcher rd = request.getRequestDispatcher(
			"template.jsp?BODY=itemRead.jsp");
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













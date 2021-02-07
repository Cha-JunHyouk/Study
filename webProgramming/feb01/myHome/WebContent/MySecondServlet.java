package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySecondServlet
 */
@WebServlet("/doIt")
public class MySecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("NAME");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		System.out.println(name+","+addr+","+tel);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");//한글처리
		String name = request.getParameter("NAME");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		System.out.println("POST:"+name+","+addr+","+tel);
	}

}















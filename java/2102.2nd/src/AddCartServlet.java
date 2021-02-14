package item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("CODE");
		HttpSession session = request.getSession();//���ǻ���? ������ã������
		String loginId = (String)session.getAttribute("LOGIN");//������ ã��
		Cart cart = (Cart)session.getAttribute("CART");//��ٱ��ϰ�ü�� ����
		if(cart == null) cart = new Cart(loginId);
		//1.�α����� �� ó������ ��ǰ�� ��� ��� new Cart(����);
		//2.�α����� �� �̹� ��ǰ�� ���� ���:������ Cart�� ��ǰ�� ��´�.
		
		//�α����� �� ó������ ��ǰ�� ��´�. -> new Cart()
		//���ݻ����� Cart��ü�� ���ǿ� �����Ѵ�.
		//�̹� ��ǰ�� �������, ������ Cart��ü�� ���ǿ��� ã�Ƽ� ��ǰ�� ��´�.
		
		//���ǿ� Cart�� ����. -> �α����� �� ó������ ��ǰ�� ��� ���
		//���ǿ� Cart�� �ִ�. -> �̹� ��ǰ�� ���� ���
		cart.addCart(Integer.parseInt(pid), 1);
		//��ǰ��ȣ�� ������ ��ٱ��Ͽ� �����Ѵ�.
		//��ٱ��Ͽ� ��ǰ�� ���� ��� JSP(addCartResult.jsp)�� ��ȯ�Ѵ�.
		response.sendRedirect("addCartResult.jsp?CODE="+pid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














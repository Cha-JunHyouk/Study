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
		HttpSession session = request.getSession();//세션생성? 계정을찾기위해
		String loginId = (String)session.getAttribute("LOGIN");//계정을 찾음
		Cart cart = (Cart)session.getAttribute("CART");//장바구니객체를 생성
		if(cart == null) cart = new Cart(loginId);
		//1.로그인한 후 처음으로 상품을 담는 경우 new Cart(계정);
		//2.로그인한 후 이미 상품을 담은 경우:기존의 Cart에 상품을 담는다.
		
		//로그인한 후 처음으로 상품을 담는다. -> new Cart()
		//지금생성한 Cart객체를 세션에 저장한다.
		//이미 상품을 담은경우, 기존의 Cart객체를 세션에서 찾아서 상품을 담는다.
		
		//세션에 Cart가 없다. -> 로그인한 후 처음으로 상품는 담는 경우
		//세션에 Cart가 있다. -> 이미 상품을 담은 경우
		cart.addCart(Integer.parseInt(pid), 1);
		//상품번호와 갯수를 장바구니에 저장한다.
		//장바구니에 상품을 담은 결과 JSP(addCartResult.jsp)로 전환한다.
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














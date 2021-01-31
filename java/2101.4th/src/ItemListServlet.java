package item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Item;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList.do")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private List<Item> getAllItems(){
    	Crud crud = new Crud();
    	List<Item> itemList = crud.getAllItems();
		Iterator it = itemList.iterator();//5개만 추출한다.
		ArrayList<Item> fiveItems = new ArrayList<Item>();//5개만 저장할목록
		for(int i=0; i<5; i++) {//5회 반복
			if(it.hasNext()) {//검색할 데이터가 존재하는 경우
				Item item = (Item)it.next();
				fiveItems.add(item);
			}else {
				break;//반복 종료
			}
		}
		return fiveItems;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("PAGENO");
		Crud crud = new Crud();
		List<Item> resultList = null;
		if(pageNo != null) {
			resultList = crud.getItembyPage(Integer.parseInt(pageNo));
		}else {
			resultList = getAllItems();
		}
		int totalCount = crud.getAllItemsCount();
		int pageCount = (totalCount + 4) / 5;
		//상품정보(5개)와 페이지 갯수를 목록을 보여주는 JSP(itemList.jsp)로 전달
		request.setAttribute("PAGECNT", pageCount);
		request.setAttribute("ITEMLIST", resultList);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=itemList.jsp");
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














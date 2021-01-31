package bbs;

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
		String pageNo = request.getParameter("PAGENO");//클릭한 페이지번호
		Crud crud = new Crud();
		List<BBS> bbsList = null;
		if(pageNo != null) {
			bbsList = crud.getBBSbyPage(Integer.parseInt(pageNo));
		}else {
			bbsList = readBBS();
		}
		//검색한 결과를 jsp(bbsList.jsp)로 전송, Redirect? Forward?
		
		//페이지 수를 찾는다.(전체글의 갯수 + 4) / 5
		//전체글의 갯수(SQL이 필요:select count(*) from remember_bbs)
		int totalCount = crud.getTotalCount();
		int pageCount = (totalCount + 4) / 5;//필요한 페이지 수를 찾음
		request.setAttribute("PAGECNT", pageCount);
		request.setAttribute("BBSLIST", bbsList);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsList.jsp");
		rd.forward(request, response);
	}
	private List<BBS> readBBS(){
		Crud crud = new Crud();
		List<BBS> bbsList = crud.getAllBBS();//모든 게시글 검색
		ArrayList<BBS> fiveList = new ArrayList<BBS>(); 
		Iterator it = bbsList.iterator();
		for(int i=0; i<5; i++) {//5회 반복
			if(it.hasNext()) {//추출할 데이터가 있는 경우
				BBS bbs = (BBS)it.next();//한 번 이동해서 데이터 추출
				fiveList.add(bbs);
			}else {//추출할 데이터가 없는 경우
				break;//반복 종료
			}
		}
		return fiveList;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














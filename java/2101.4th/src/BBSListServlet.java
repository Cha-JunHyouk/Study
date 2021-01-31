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
		//remember_bbs���� ��� �Խñ��� �˻�
		String pageNo = request.getParameter("PAGENO");//Ŭ���� ��������ȣ
		Crud crud = new Crud();
		List<BBS> bbsList = null;
		if(pageNo != null) {
			bbsList = crud.getBBSbyPage(Integer.parseInt(pageNo));
		}else {
			bbsList = readBBS();
		}
		//�˻��� ����� jsp(bbsList.jsp)�� ����, Redirect? Forward?
		
		//������ ���� ã�´�.(��ü���� ���� + 4) / 5
		//��ü���� ����(SQL�� �ʿ�:select count(*) from remember_bbs)
		int totalCount = crud.getTotalCount();
		int pageCount = (totalCount + 4) / 5;//�ʿ��� ������ ���� ã��
		request.setAttribute("PAGECNT", pageCount);
		request.setAttribute("BBSLIST", bbsList);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsList.jsp");
		rd.forward(request, response);
	}
	private List<BBS> readBBS(){
		Crud crud = new Crud();
		List<BBS> bbsList = crud.getAllBBS();//��� �Խñ� �˻�
		ArrayList<BBS> fiveList = new ArrayList<BBS>(); 
		Iterator it = bbsList.iterator();
		for(int i=0; i<5; i++) {//5ȸ �ݺ�
			if(it.hasNext()) {//������ �����Ͱ� �ִ� ���
				BBS bbs = (BBS)it.next();//�� �� �̵��ؼ� ������ ����
				fiveList.add(bbs);
			}else {//������ �����Ͱ� ���� ���
				break;//�ݺ� ����
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














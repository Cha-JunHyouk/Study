package bbs;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud;
import model.BBS;

/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/bbsPost")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");//�ѱ�ó��(POST)
		String title = request.getParameter("TITLE");//������
		String content = request.getParameter("CONTENT");//�۳���
		HttpSession session = request.getSession();//������ ã�´�.
		String id = (String)session.getAttribute("LOGIN");//�ۼ���(�α����� ����)
		Calendar today = Calendar.getInstance();//�ۼ���
		int year = today.get(Calendar.YEAR);//�⵵�� ã��
		int month = today.get(Calendar.MONTH) + 1;//���� ã��(0~11) + 1
		int date = today.get(Calendar.DATE);//���� ã��
		int hour = today.get(Calendar.HOUR_OF_DAY);//�ð�(24�ð�)�� ã��
		int min = today.get(Calendar.MINUTE);//���� ã�� 
		int sec = today.get(Calendar.SECOND);//�ʸ� ã��
		String inputDate = year+"/"+month+"/"+date+" "+hour
				+":"+min+":"+sec;
		//remember_bbs ���̺��� ���� ū seqno�� select + 1
		Crud crud = new Crud();
		int maxSeqno = crud.getMaxSeqno() + 1;
		//�۹�ȣ,����,����,�ۼ���,�ۼ��� ������ DTO(BBS)�� �ִ´�.
		BBS bbs = new BBS();
		bbs.setSeqno(maxSeqno);//�۹�ȣ ����
		bbs.setTitle(title);//������ ����
		bbs.setId(id);//�ۼ��� ����
		bbs.setContent(content);//�۳��� ����
		bbs.setBbs_date(inputDate);//�ۼ��� ����
		
		int result = crud.putBBS(bbs);//remember_bbs ���̺� insert
		String r = "";
		if(result > 0) r = "OK";
		else r = "NOK";
		//�Խñ� ��� ��� ��������(bbsResult.jsp) ��ȯ Redirect? Forward?
		response.sendRedirect("template.jsp?BODY=bbsResult.jsp?R="+r);
	}
}




















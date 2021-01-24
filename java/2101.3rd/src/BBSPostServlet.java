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
		request.setCharacterEncoding("euc-kr");//한글처리(POST)
		String title = request.getParameter("TITLE");//글제목
		String content = request.getParameter("CONTENT");//글내용
		HttpSession session = request.getSession();//세션을 찾는다.
		String id = (String)session.getAttribute("LOGIN");//작성자(로그인한 계정)
		Calendar today = Calendar.getInstance();//작성일
		int year = today.get(Calendar.YEAR);//년도를 찾음
		int month = today.get(Calendar.MONTH) + 1;//월을 찾음(0~11) + 1
		int date = today.get(Calendar.DATE);//일을 찾음
		int hour = today.get(Calendar.HOUR_OF_DAY);//시간(24시간)을 찾음
		int min = today.get(Calendar.MINUTE);//분을 찾음 
		int sec = today.get(Calendar.SECOND);//초를 찾음
		String inputDate = year+"/"+month+"/"+date+" "+hour
				+":"+min+":"+sec;
		//remember_bbs 테이블에서 가장 큰 seqno를 select + 1
		Crud crud = new Crud();
		int maxSeqno = crud.getMaxSeqno() + 1;
		//글번호,제목,내용,작성장,작성일 정보를 DTO(BBS)에 넣는다.
		BBS bbs = new BBS();
		bbs.setSeqno(maxSeqno);//글번호 설정
		bbs.setTitle(title);//글제목 설정
		bbs.setId(id);//작성자 설정
		bbs.setContent(content);//글내용 설정
		bbs.setBbs_date(inputDate);//작성일 설정
		
		int result = crud.putBBS(bbs);//remember_bbs 테이블에 insert
		String r = "";
		if(result > 0) r = "OK";
		else r = "NOK";
		//게시글 등록 결과 페이지로(bbsResult.jsp) 전환 Redirect? Forward?
		response.sendRedirect("template.jsp?BODY=bbsResult.jsp?R="+r);
	}
}




















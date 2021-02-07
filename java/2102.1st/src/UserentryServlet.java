package userentry;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jaegu;

/**
 * Servlet implementation class UserentryServlet
 */
@WebServlet("/register")
public class UserentryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserentryServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("NAME");//이름
		String id = request.getParameter("ID");//계정
		String pwd = request.getParameter("PASSWORD");//암호
		String gender = request.getParameter("GENDER");//성별
		String email = request.getParameter("EMAIL");//이메일
		String job = request.getParameter("JOB");//직업
		String addr = request.getParameter("ADDR");//주소
		String tel = request.getParameter("TEL");//연락처
		Calendar today = Calendar.getInstance();
		String joinDate = "";
		int year = today.get(Calendar.YEAR);
		joinDate = joinDate + year;
		int month = today.get(Calendar.MONTH) + 1;
		if(month < 10) {
			joinDate = joinDate + "/0"+month;
		}else {
			joinDate = joinDate + "/"+month;
		}
		int date = today.get(Calendar.DATE);
		if(date < 10) {
			joinDate = joinDate + "/0"+date;
		}else {
			joinDate = joinDate + "/"+date;
		}
		int hh = today.get(Calendar.HOUR_OF_DAY);
		if(hh < 10) {
			joinDate = joinDate + " 0"+hh;
		}else {
			joinDate = joinDate + " "+hh;
		}
		int mm = today.get(Calendar.MINUTE);
		if(mm < 10) {
			joinDate = joinDate + ":0"+mm;
		}else {
			joinDate = joinDate + ":"+mm;
		}
		int ss = today.get(Calendar.SECOND);
		if(ss < 10) {
			joinDate = joinDate + ":0"+ss;
		}else {
			joinDate = joinDate + ":"+ss;
		}
		//위의 데이터를 DTO(Jaegu)에 넣는다.
		Jaegu dto = new Jaegu();
		dto.setId(id);
		dto.setPassword(pwd);
		if(gender.equals("M")) dto.setGender("남자");
		else dto.setGender("여자");
		dto.setAddress(addr);
		dto.setName(name);
		dto.setPhonenumber(tel);
		dto.setJoindate(joinDate);
		dto.setEmail(email);
		dto.setJob(job);
		//CRUD에서 메서드를 호출해서 DTO를 전달한다.
		//등록결과 JSP로 전환한다.
	}

}





















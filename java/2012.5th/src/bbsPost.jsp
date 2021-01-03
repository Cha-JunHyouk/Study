<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, java.io.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");//한글처리
	String name = request.getParameter("NAME");//파라미터를 수신
	String title = request.getParameter("TITLE");
	String content = request.getParameter("CONTENT");
	Date date = new Date();//게시글 작성일을 위해 날짜객체 생성.import한다.
	Long time = date.getTime();//1970년1월1일부터 현재까지의 초를 획득
	String filename = time+"_"+name+".txt";//파일명 설정
	PrintWriter writer = null;//파일생성전용객체 선언. import한다.
	String jsp = "";//화면을 전활할 JSP이름이 저장될 변수
	try{
		String filePath=application.getRealPath("/WEB-INF/bbs/"+filename);
		out.print("생성된 파일위치:"+filePath);
		writer = new PrintWriter(filePath);//경로와 파일명으로 객체생성
		writer.printf("제목:%s%n",title);//제목을 파일로 출력
		writer.printf("작성자:%s%n",name);//작성자를 파일로 출력
		writer.printf(content);//글 내용을 파일로 출력
		jsp = "bbsResultOK.jsp";
	}catch(Exception e){
		e.printStackTrace();
		jsp = "bbsResultNOK.jsp";
	}finally{
		try{ writer.close(); }catch(Exception e){}
	}
	response.sendRedirect(jsp);//Redirect로 화면 전환
%>
</body>
</html>




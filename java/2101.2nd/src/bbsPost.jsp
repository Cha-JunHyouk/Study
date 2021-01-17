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
	request.setCharacterEncoding("euc-kr");//�ѱ�ó��
	String name = request.getParameter("NAME");//�Ķ���͸� ����
	String title = request.getParameter("TITLE");
	String content = request.getParameter("CONTENT");
	Date date = new Date();//�Խñ� �ۼ����� ���� ��¥��ü ����.import�Ѵ�.
	Long time = date.getTime();//1970��1��1�Ϻ��� ��������� �ʸ� ȹ��
	String filename = time+"_"+name+".txt";//���ϸ� ����
	PrintWriter writer = null;//���ϻ������밴ü ����. import�Ѵ�.
	String jsp = "";//ȭ���� ��Ȱ�� JSP�̸��� ����� ����
	try{
		String filePath=application.getRealPath("/WEB-INF/bbs/"+filename);
		out.print("������ ������ġ:"+filePath);
		writer = new PrintWriter(filePath);//��ο� ���ϸ����� ��ü����
		writer.printf("����:%s%n",title);//������ ���Ϸ� ���
		writer.printf("�ۼ���:%s%n",name);//�ۼ��ڸ� ���Ϸ� ���
		writer.printf(content);//�� ������ ���Ϸ� ���
		jsp = "bbsResultOK.jsp";
	}catch(Exception e){
		e.printStackTrace();
		jsp = "bbsResultNOK.jsp";
	}finally{
		try{ writer.close(); }catch(Exception e){}
	}
	response.sendRedirect(jsp);//Redirect�� ȭ�� ��ȯ
%>
</body>
</html>




<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>���� ���� ����</h2>
<%
	String id = request.getParameter("ID");//���� ��ȣ�� ����
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from matjip_inform where id=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	pstmt.setInt(1, Integer.parseInt(id));
	ResultSet rs = pstmt.executeQuery();
	if(rs == null){
		out.print("<h2>�˻� ����� �������� �ʽ��ϴ�.</h2>");		
	}else {
		rs.next();//��ȸ ����� �̵�
		int seqno = rs.getInt(1);//��ȸ����� ù��° �÷� �� ����
		String title = rs.getString(2);//��ȸ����� �ι�° �÷� �� ����
		String addr = rs.getString("addr");//��ȸ����� addr �÷� �� ����
		String phone = rs.getString("phone");
		String menu = rs.getString(5);
		String menuName = "";
		switch(menu){
		case "K":menuName="�ѽ�"; break;
		case "A":menuName="���"; break;
		case "C":menuName="�߽�"; break;
		case "J":menuName="�Ͻ�"; break;
		case "M":menuName="�н�"; break;
		case "E":menuName="��Ÿ"; break;
		}
		String intro = rs.getString(6);
%>
<form action="updateMatjipInfo.jsp" method="post">
	<table border="1">
		<tr><td>���� ��ȣ</td>
			<td><input type="text" name="ID" value="<%= seqno %>" readonly/>
			</td></tr>
		<tr><td>�̸�</td>
			<td><input type="text" name="TITLE" value="<%= title %>"/>
			</td></tr>
		<tr><td>�ּ�</td>
			<td><input type="text" name="ADDR" value="<%= addr %>"/>
			</td></tr>
		<tr><td>����ó</td>
			<td><input type="text" name="PHONE" value="<%= phone %>"/>
			</td></tr>
		<tr><td>�޴�</td>
			<td>�ѽ�
<%
	if(menu.equals("K")){
		out.print("<input type='radio' name='MENU' value='K' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='K' />");
	}
%>
				���
<%
	if(menu.equals("A")){
		out.print("<input type='radio' name='MENU' value='A' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='A' />");
	}
%>
				�߽�
<%
	if(menu.equals("C")){
		out.print("<input type='radio' name='MENU' value='C' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='C' />");
	}
%>
				�Ͻ�
<%
	if(menu.equals("J")){
		out.print("<input type='radio' name='MENU' value='J' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='J' />");
	}
%>				
				�н�
<%
	if(menu.equals("M")){
		out.print("<input type='radio' name='MENU' value='M' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='M' />");
	}
%>				
				��Ÿ
<%
	if(menu.equals("E")){
		out.print("<input type='radio' name='MENU' value='E' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='E' />");
	}
%>				
			</td></tr>
		<tr><td>�Ұ���</td>
			<td><textarea rows="8" cols="40" name="INTRO"><%= intro %></textarea>
			</td></tr>
		<tr><td colspan="2"><input type="submit" value=" �������� "/>
			<input type="reset" value=" ��� "/>
		</tr>
	</table>
</form>
<%		
	}
	rs.close(); pstmt.close(); conn.close();
%>
</div>
</body>
</html>










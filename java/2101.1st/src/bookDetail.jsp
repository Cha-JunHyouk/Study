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
<div align="center"><h2>���� �� ����</h2></div>
<%
	String seqno = request.getParameter("SEQNO");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from books_info where seqno=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	int no = Integer.parseInt(seqno);//���ڿ� �Ϸù�ȣ�� ���� �Ϸù�ȣ�κ���
	pstmt.setInt(1, no);//�˻� ������ ù��° ����ǥ�� ���� �Ϸù�ȣ�� �Ҵ�
	ResultSet rs = pstmt.executeQuery();//�˻� ���� ����
	if(rs == null){
		out.println("�˻��� ����� �������� �ʽ��ϴ�.");
	}else{
		while(rs.next()){//��ȸ ����� �̵�
			int serial = rs.getInt(1);//ù��° �˻� �׸�(seqno)�� ����
			String title = rs.getString(2);//�ι�° �˻� �׸�(name)�� ����
			String writer = rs.getString("writer");//writer�׸��� ����
			String company = rs.getString(4);//�׹�° �˻� �׸�(publisher)
			int price = rs.getInt("price");//price�׸��� ����
%>
<form action="deleteOrModify.jsp" method="post">
	<input type="hidden" value="<%= serial %>" name="SEQNO"/>
	<input type="hidden" value="<%= title %>" name="TITLE"/>
	<input type="hidden" value="<%= writer %>" name="WRITER"/>
	<input type="hidden" value="<%= company %>" name="COMPANY"/>
	<input type="hidden" value="<%= price %>" name="PRICE"/>
	<table border="1">
		<tr><td width="100" height="20" bgcolor="cyan">�Ϸù�ȣ</td>
			<td width="150" height="20" bgcolor="cyan">�� ��</td>
			<td width="150" height="20" bgcolor="cyan">�� ��</td>
			<td width="150" height="20" bgcolor="cyan">���ǻ�</td>
			<td width="100" height="20" bgcolor="cyan">�� ��</td>
			<td width="100" height="20" bgcolor="cyan">&nbsp;</td></tr>
		<tr><td width="100" height="20"><%= serial %></td>
			<td width="150" height="20"><%= title %></td>
			<td width="150" height="20"><%= writer %></td>
			<td width="150" height="20"><%= company %></td>
			<td width="100" height="20"><%= price %></td>
			<td width="100" height="20">
			<input type="submit" value="�����ϱ�" name="BTN"/>
			<input type="submit" value="�����ϱ�" name="BTN"/>
			</td></tr>
	</table>
</form>
<%			
		}
	}
%>
</body>
</html>











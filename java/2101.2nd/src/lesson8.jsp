<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Ŀ���� �׼� �±�(JSTL)</h2>
�� �ݺ� ���(���ڿ��� ��ū���� �и��ϰ� ������ ��ū�� �ݺ�ó��)<br/>
<c:forTokens var="name" items="��� �� ���� Ű��" delims=" ">
${name }
</c:forTokens><br/>
<c:forTokens var="animal" items="ȣ����/�����/������/��踻" delims="/">
${animal }
</c:forTokens><br/>
<c:forTokens var="item" items="��ǻ��*����*TV*�����" delims="*">
${item }
</c:forTokens><br/>
<c:forTokens var="lang" items="�ڹ�*JSP/����-�����ӿ�ũ" delims="*/-">
${lang }
</c:forTokens><br/>
<c:forTokens var="word" items="1000,10000,3000.25000,123000.1200,153200" 
		delims=",.">
${word }<br/>
</c:forTokens><br/>
�� ����ó��<br/>
<%
	int num1 = 100; int num2 = 0;
%>
<c:catch var="e">
<%
	int result = num1 / num2;	//0���� ������ ���ܰ� �߻��Ѵ�.
%>
�������� ����� <%= result %> �Դϴ�.<br/>
</c:catch>
<c:if test="${ e != null }">
	���� �޼��� : ${e.message }<br/>
</c:if>
�� ������ ��ȯ:Redirect�� Forward<br/>
Forward�� ��ȯ�� forward��� ǥ�� �׼� �±׸� ����Ѵ�.<br/>
Redirect�� ��ȯ��? �Ʒ��� ����<br/>
<c:redirect url="result8.jsp">
	<c:param name="NAME" value="APPLE"/>
	<c:param name="PRICE" value="1200"/>
</c:redirect>
</body>
</html>














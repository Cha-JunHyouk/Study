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
�� �������� ���<br/>
<%
	out.print("�� ���� �������� ��µ˴ϴ�.<br/>");
%>
<c:out value="�� ���� �������� ��µ˴ϴ�.<br/>"/>
<br/>
<c:out value="�� ���� �������� ��µ˴ϴ�.<br/>" escapeXml="false"/>
<c:out value="<font size='7'>ū �۾�</font>"/>
<br/>
<c:out value="<font size='7'>ū �۾�</font>" escapeXml="false"/>
</body>
</html>












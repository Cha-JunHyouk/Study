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
<h2>Ŀ���� �׼� �±׸� ����մϴ�.</h2>
<h3>�ھ� ���</h3>
�� �ݺ����<br/>
<%
	String[] arr = {"���ѹα�","�߱�","�Ϻ�","����","��Ʈ��","�븸"};
	request.setAttribute("ASIAN", arr);
%>
<jsp:forward page="result7.jsp"/>
</body>
</html>
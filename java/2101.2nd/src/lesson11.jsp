<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Ŀ���� �׼� �±�:������ ���</h2>
�� ������ �ٲپ ���� ��¥�� �ð��� �ش� ������ ��¥�� �ð����� ����<br/>
������ ������ "����� �̱�" �������� �ٲߴϴ�.<br/>
<fmt:setLocale value="en_us"/><br/>
������ ����� en�� ������� �ǹ��Ѵ�. ������ ��������� �ٲٰ� ��¥�� 
����ϸ� ����ǿ��� ����ϴ� ���·� ��¥�� ��µȴ�.<br/> 
<c:set var="today" value="<%= new Date() %>"/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
������ ������ "�Ͼ��" �������� �ٲߴϴ�.<br/>
<fmt:setLocale value="ja_jp"/><br/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
������ ������ "�ѱ����" �������� �ٽ� �ٲߴϴ�.<br/>
<fmt:setLocale value="ko_kr"/><br/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
�� �ð��븦 �ٲپ ���� �ٸ� �ð����� �ð��� �� �� �ִ�.<br/>
������ �ϾƸ޸�ī�� �������� �ð��븦 �ٲߴϴ�.<br/>
<fmt:timeZone value="America/New_York">
��¥ : <fmt:formatDate value="${today }" type="date"/><br/>
�ð� : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
������ ������ ����, �������� �ð��븦 �ٲߴϴ�.<br/>
<fmt:timeZone value="Europe/London">
��¥ : <fmt:formatDate value="${today }" type="date"/><br/>
�ð� : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
������ �ƽþ��� ȫ������ �ð��븦 �ٲߴϴ�.<br/>
<fmt:timeZone value="Asia/Hong_Kong">
��¥ : <fmt:formatDate value="${today }" type="date"/><br/>
�ð� : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
value�� ���� ���ڿ��� �ٲٸ�, �� ���� ��������̵��� �ð��븦 �ٲ� �� 
�ִ�. ��� value�� ���� ���ڿ��� �� �� �ֳ���?<br/>
�ڹ��� TimeZone�̶�� Ŭ������ ������, �� Ŭ������ ������ �ִ� 
getAvailableIDs()��� �޼��带 ȣ���ϸ� �� ���� ������ ��ǥ�ϴ� �ð���
�̸��� �� �� �ִ�.<br/>
������ �ڹ��� TimeZoneŬ������ getAvaiableIDs()�޼��带 ȣ���ϰ�, �� �����
�������� ����մϴ�.<br/>
<%
	String[] timezoneList = TimeZone.getAvailableIDs();
	for(int i = 0; i<timezoneList.length; i++){
		out.print(timezoneList[i]+"<br/>");	
	}
%>
</body>
</html>














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
<h2>Ŀ���� �׼� �±�(JSTL)�� ������ ���</h2>
�ھ� ����� uri="http://java.sun.com/jsp/jstl/core"  prefix="c"<br/>
������ ����� uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"<br/>
<c:set var="today" value="<%= new Date() %>"/>
<fmt:formatDate value="${today }"/><br/>
���� ��¥�� YYYY. MM. DD���·� ��µ˴ϴ�. �Ʒ�ó�� �ð��� ����� ����
�ֽ��ϴ�.<br/>
<fmt:formatDate value="${today }" type="time"/><br/>
��¥�� �ð��� ��� ����� ���� �ֽ��ϴ�.<br/>
<fmt:formatDate value="${today }" type="both"/><br/>
��µǴ� ��¥�� �ð������� ���� ����,����,���,���η� ������ �� �ֽ��ϴ�.<br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="short" timeStyle="short"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="medium" timeStyle="medium"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="long" timeStyle="long"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="full" timeStyle="full"/><br/>
��µǴ� ��¥�� ���¸� �ٲ� ���� �ֽ��ϴ�.<br/>
<fmt:formatDate value="${today }" type="date" pattern="yyyy/MM/dd (E)"/><br/>
��µǴ� �ð��� ���¸� �ٲ� ���� �ֽ��ϴ�.<br/>
<fmt:formatDate value="${today }" type="time" pattern="(a) hh:mm:ss"/><br/>
�� ���� �������� ��µǴ� ���¸� �����մϴ�<br/>
�Ʒ��� ���ڴ� �ڵ����� õ������ �޸�(,)�� ���ϴ�.<br/>
<fmt:formatNumber value="1289980" groupingUsed="true"/>��<br/>
�Ʒ��� ���ڴ� �Ҽ��� ���� �� ��ȿ���ڸ� ����մϴ�.<br/>
<fmt:formatNumber value="123.14558" pattern="#.##"/><br/>
�Ʒ��� ���ڴ� �Ҽ��� ���Ͽ� ������ 0�� ���ϴ�.<br/>
<fmt:formatNumber value="100.5" pattern="#.00"/><br/>	
�Ʒ��� ���ڴ� ��ġ�� �ۼ�Ʈ�� ����մϴ�.<br/>
<fmt:formatNumber value="0.68" type="percent"/><br/>
�Ʒ��� ���ڴ� ��ġ�տ� ȭ������� ���ϴ�. �Ϲ������� ������ ���� �� 
�ڸ� ���� ��µ˴ϴ�. ȭ������� �ȳ����׿�~ --<br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
ȭ������� ����Ϸ��� �Ʒ��� ���� �ϼ���~(����+����)<br/>
<fmt:formatNumber value="3400000.566" type="currency" 
			currencySymbol="��"/><br/>
</body>
</html>




















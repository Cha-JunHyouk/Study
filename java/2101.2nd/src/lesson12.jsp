<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Ŀ���� �׼� �±�(������ ���)</h2>
�� ������Ƽ��(properties) ������ �̿��ؼ� �ٱ��� �������� �ۼ��� �� �ִ�.<br/>
������Ƽ�� ������ ����� ��Ģ<br/>
1. ��ġ : /WEB-INF/ �ؿ� classes��� �̸����� ������ ����� �� ���� ��ġ<br/>
2. �̸� : Ȯ���ڴ� �ݵ�� .properties �̰�, �̸��� �����ε� �̸��� ����ڵ带
����ؾ� �Ѵ�. �ѱ��� ����ڵ�� ko, ������ ��� �ڵ� en, �Ϻ��� ��� �ڵ� ja<br/>
������Ƽ�� ������ ��: intro_ko.properties,intro_en.properties,
intro_ja.properties<br/>
���� ������ intro�� ������ �̸�, _ko _en _ja ��� �ڵ�.<br/>
������ �̸� : menu<br/>
menu_ko.properties, menu_en.properties, menu_ja.properties<br/>
������ ���� ���������� ������ �����Ѵ�.<br/>
<fmt:setBundle basename="test"/>
������ ���� ������Ƽ�� ���Ͽ� ����� Ű�� �����մϴ�.<br/>
<h2><fmt:message key="TITLE"/></h2>
<fmt:message key="FIRST"/><br/>
<fmt:message key="SECOND"/><br/>
<h2><fmt:message key="THIRD"/></h2>
</body>
</html>















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
<h3>Ŀ���� �׼� �±�</h3>
ǥ�� �±װ� �ƴϹǷ�, �� �±׸� ����Ϸ��� ������ ������ ��ġ�ؾ� �Ѵ�.<br/>
jstl.jar�� standard.jar�� /WEB-INF/lib �ؿ� ��ġ�Ѵ�.<br/>
Ŀ���� �׼� �±״� ǥ�� �ƴ�����, �ڹٰ� ���� JSP���� ���� �ʼ������� �ʿ���
�±��̱� ������ ��ġ ǥ�ذ� ���� ���� ����Ѵ�.<br/>
Ư��, �񱳿� �ݺ�ó���� ���ؼ��� �ʼ����̴�.<br/>
Ŀ���� �׼� �±״� �ټ����� ������� ���еȴ�. �� ��ɿ� �̸��� �ο��ϰ� �ִ�.
�̸��� ������ ����. �ھ�, ������, �Լ�, �����ͺ��̽�, XML<br/>
<h3>�ھ� ���</h3>
�Ϲ������� ���α׷��־��� �����ϴ� ��������,���Ǻ�,�ݺ�ó�� ���� �����
 ������ �ִ�.<br/>
�� ��������<br/>
<c:set var="num1" value="100"/>
<c:set var="num2" value="200"/>
<c:set var="sum" value="${num1 + num2 }"/>
������ ��� : ${sum }<br/>
<c:remove var="num1"/>
<c:remove var="num2"/>
<c:remove var="sum"/><br/>
�� �񱳿���<br/>
<c:set var="num1" value="123"/>
<c:set var="num2" value="321"/>
<c:if test="${num1 > num2 }">
${num1 }�� Ů�ϴ�.<br/>
</c:if>
<c:if test="${num2 > num1 }">
${num2 }�� Ů�ϴ�.<br/>
</c:if>
<c:choose>
	<c:when test="${num1 > 100 }">
	100���� Ů�ϴ�.<br/>
	</c:when>
	<c:when test="${num1 < 100 }">
	100���� �۽��ϴ�.<br/>
	</c:when>
	<c:otherwise>
	100�� �����ϴ�.
	</c:otherwise>
</c:choose>
�� �ݺ�����<br/>
<c:forEach begin="1" end="10">
�� ������ ���� ��µ˴ϴ�.<br/>
</c:forEach>
<table border="1">
		<tr><th>����1</th><th>����2</th></tr>
	<c:forEach begin="1" end="5">
		<tr><td>1��</td><td>2��</td></tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="5">
	<a href="">${page }</a>
</c:forEach>
<br/>
<c:forEach var="num" begin="1" end="20" step="2">
	${num }
</c:forEach>
<br/>
�۾��� ���� Ŀ���ϴ�.<br/>
<c:forEach var="size" begin="1" end="5">
<font size="${size }" color="red">�����~</font>
</c:forEach>
</body>
</html>




























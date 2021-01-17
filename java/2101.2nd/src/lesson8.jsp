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
<h2>커스텀 액션 태그(JSTL)</h2>
■ 반복 기능(문자열을 토큰으로 분리하고 각각의 토큰을 반복처리)<br/>
<c:forTokens var="name" items="사과 배 포도 키위" delims=" ">
${name }
</c:forTokens><br/>
<c:forTokens var="animal" items="호랑이/고양이/강아지/얼룩말" delims="/">
${animal }
</c:forTokens><br/>
<c:forTokens var="item" items="컴퓨터*라디오*TV*냉장고" delims="*">
${item }
</c:forTokens><br/>
<c:forTokens var="lang" items="자바*JSP/서블릿-프레임워크" delims="*/-">
${lang }
</c:forTokens><br/>
<c:forTokens var="word" items="1000,10000,3000.25000,123000.1200,153200" 
		delims=",.">
${word }<br/>
</c:forTokens><br/>
■ 예외처리<br/>
<%
	int num1 = 100; int num2 = 0;
%>
<c:catch var="e">
<%
	int result = num1 / num2;	//0으로 나누면 예외가 발생한다.
%>
나눗셈의 결과는 <%= result %> 입니다.<br/>
</c:catch>
<c:if test="${ e != null }">
	에러 메세지 : ${e.message }<br/>
</c:if>
■ 페이지 전환:Redirect와 Forward<br/>
Forward로 전환은 forward라는 표준 액션 태그를 사용한다.<br/>
Redirect로 전환은? 아래와 같다<br/>
<c:redirect url="result8.jsp">
	<c:param name="NAME" value="APPLE"/>
	<c:param name="PRICE" value="1200"/>
</c:redirect>
</body>
</html>














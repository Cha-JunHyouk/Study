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
<h2>커스텀 액션 태그:포맷팅 기능</h2>
■ 지역을 바꾸어서 현재 날짜와 시간을 해당 지역의 날짜와 시간으로 변경<br/>
다음은 지역을 "영어권 미국" 지역으로 바꿉니다.<br/>
<fmt:setLocale value="en_us"/><br/>
위에서 사용한 en은 영어권을 의미한다. 지역을 영어권으로 바꾸고 날짜를 
출력하면 영어권에서 사용하는 형태로 날짜가 출력된다.<br/> 
<c:set var="today" value="<%= new Date() %>"/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
다음은 지역을 "일어권" 지역으로 바꿉니다.<br/>
<fmt:setLocale value="ja_jp"/><br/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
다음은 지역을 "한국어권" 지역으로 다시 바꿉니다.<br/>
<fmt:setLocale value="ko_kr"/><br/>
<fmt:formatDate value="${today }"/><br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
■ 시간대를 바꾸어서 현재 다른 시간대의 시간을 볼 수 있다.<br/>
다음은 북아메리카의 뉴욕으로 시간대를 바꿉니다.<br/>
<fmt:timeZone value="America/New_York">
날짜 : <fmt:formatDate value="${today }" type="date"/><br/>
시각 : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
다음은 유럽의 영국, 런던으로 시간대를 바꿉니다.<br/>
<fmt:timeZone value="Europe/London">
날짜 : <fmt:formatDate value="${today }" type="date"/><br/>
시각 : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
다음은 아시아의 홍콩으로 시간대를 바꿉니다.<br/>
<fmt:timeZone value="Asia/Hong_Kong">
날짜 : <fmt:formatDate value="${today }" type="date"/><br/>
시각 : <fmt:formatDate value="${today }" type="time"/><br/>
</fmt:timeZone>
value에 들어가는 문자열만 바꾸면, 전 세계 어느지역이든지 시간대를 바꿀 수 
있다. 어떻게 value에 들어가는 문자열을 알 수 있나요?<br/>
자바의 TimeZone이라는 클래스가 있으며, 이 클래스가 가지고 있는 
getAvailableIDs()라는 메서드를 호출하면 전 세계 지역을 대표하는 시간대
이름을 알 수 있다.<br/>
다음은 자바의 TimeZone클래스의 getAvaiableIDs()메서드를 호출하고, 그 결과를
브라우저로 출력합니다.<br/>
<%
	String[] timezoneList = TimeZone.getAvailableIDs();
	for(int i = 0; i<timezoneList.length; i++){
		out.print(timezoneList[i]+"<br/>");	
	}
%>
</body>
</html>














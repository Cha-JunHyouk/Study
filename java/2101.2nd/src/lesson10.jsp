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
<h2>커스텀 액션 태그(JSTL)의 포멧팅 기능</h2>
코어 기능은 uri="http://java.sun.com/jsp/jstl/core"  prefix="c"<br/>
포멧팅 기능은 uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"<br/>
<c:set var="today" value="<%= new Date() %>"/>
<fmt:formatDate value="${today }"/><br/>
위의 날짜는 YYYY. MM. DD형태로 출력됩니다. 아래처럼 시간을 출력할 수도
있습니다.<br/>
<fmt:formatDate value="${today }" type="time"/><br/>
날짜와 시간을 모두 출력할 수도 있습니다.<br/>
<fmt:formatDate value="${today }" type="both"/><br/>
출력되는 날짜와 시간정보의 양을 간단,보통,길게,전부로 조절할 수 있습니다.<br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="short" timeStyle="short"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="medium" timeStyle="medium"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="long" timeStyle="long"/><br/>
<fmt:formatDate value="${today }" type="both" 
		dateStyle="full" timeStyle="full"/><br/>
출력되는 날짜의 형태를 바꿀 수도 있습니다.<br/>
<fmt:formatDate value="${today }" type="date" pattern="yyyy/MM/dd (E)"/><br/>
출력되는 시간의 형태를 바꿀 수도 있습니다.<br/>
<fmt:formatDate value="${today }" type="time" pattern="(a) hh:mm:ss"/><br/>
■ 숫자 데이터의 출력되는 형태를 지정합니다<br/>
아래의 숫자는 자동으로 천단위에 콤마(,)가 들어갑니다.<br/>
<fmt:formatNumber value="1289980" groupingUsed="true"/>원<br/>
아래의 숫자는 소수점 이하 중 유효숫자만 출력합니다.<br/>
<fmt:formatNumber value="123.14558" pattern="#.##"/><br/>
아래의 숫자는 소수점 이하에 강제로 0이 들어갑니다.<br/>
<fmt:formatNumber value="100.5" pattern="#.00"/><br/>	
아래의 숫자는 수치를 퍼센트로 출력합니다.<br/>
<fmt:formatNumber value="0.68" type="percent"/><br/>
아래의 숫자는 수치앞에 화폐단위가 들어갑니다. 일반적으로 수수점 이하 두 
자리 까지 출력됩니다. 화폐단위가 안나오네요~ --<br/>
<fmt:formatNumber value="3400000.566" type="currency"/><br/>
화폐단위를 출력하려면 아래와 같이 하세요~(리을+한자)<br/>
<fmt:formatNumber value="3400000.566" type="currency" 
			currencySymbol="￦"/><br/>
</body>
</html>




















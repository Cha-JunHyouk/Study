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
<h3>커스텀 액션 태그</h3>
표준 태그가 아니므로, 이 태그를 사용하려면 별도의 파일을 설치해야 한다.<br/>
jstl.jar와 standard.jar를 /WEB-INF/lib 밑에 설치한다.<br/>
커스텀 액션 태그는 표준 아니지만, 자바가 없는 JSP에서 거의 필수적으로 필요한
태그이기 때문에 마치 표준과 같이 많이 사용한다.<br/>
특히, 비교와 반복처리를 위해서는 필수적이다.<br/>
커스텀 액션 태그는 다섯가지 기능으로 구분된다. 각 기능에 이름을 부여하고 있다.
이름은 다음과 같다. 코어, 포맷팅, 함수, 데이터베이스, XML<br/>
<h3>코어 기능</h3>
일반적으로 프로그래밍언어에서 제공하는 변수선언,조건비교,반복처리 등의 기능을
 가지고 있다.<br/>
■ 변수선언<br/>
<c:set var="num1" value="100"/>
<c:set var="num2" value="200"/>
<c:set var="sum" value="${num1 + num2 }"/>
덧셈의 결과 : ${sum }<br/>
<c:remove var="num1"/>
<c:remove var="num2"/>
<c:remove var="sum"/><br/>
■ 비교연산<br/>
<c:set var="num1" value="123"/>
<c:set var="num2" value="321"/>
<c:if test="${num1 > num2 }">
${num1 }이 큽니다.<br/>
</c:if>
<c:if test="${num2 > num1 }">
${num2 }이 큽니다.<br/>
</c:if>
<c:choose>
	<c:when test="${num1 > 100 }">
	100보다 큽니다.<br/>
	</c:when>
	<c:when test="${num1 < 100 }">
	100보다 작습니다.<br/>
	</c:when>
	<c:otherwise>
	100과 같습니다.
	</c:otherwise>
</c:choose>
■ 반복연산<br/>
<c:forEach begin="1" end="10">
이 문장이 열번 출력됩니다.<br/>
</c:forEach>
<table border="1">
		<tr><th>제목1</th><th>제목2</th></tr>
	<c:forEach begin="1" end="5">
		<tr><td>1열</td><td>2열</td></tr>
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
글씨가 점점 커집니다.<br/>
<c:forEach var="size" begin="1" end="5">
<font size="${size }" color="red">사랑해~</font>
</c:forEach>
</body>
</html>




























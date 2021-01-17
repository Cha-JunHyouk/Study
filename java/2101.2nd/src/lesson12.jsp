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
<h2>커스텀 액션 태그(포멧팅 기능)</h2>
■ 프로퍼티즈(properties) 파일을 이용해서 다국어 페이지를 작성할 수 있다.<br/>
프로퍼티즈 파일을 만드는 규칙<br/>
1. 위치 : /WEB-INF/ 밑에 classes라는 이름으로 폴더를 만들고 이 곳에 위치<br/>
2. 이름 : 확장자는 반드시 .properties 이고, 이름은 자유인데 이름에 언어코드를
명시해야 한다. 한글의 언어코드는 ko, 영어의 언어 코드 en, 일본어 언어 코드 ja<br/>
프로퍼티즈 파일의 예: intro_ko.properties,intro_en.properties,
intro_ja.properties<br/>
위의 예에서 intro가 파일의 이름, _ko _en _ja 언어 코드.<br/>
파일의 이름 : menu<br/>
menu_ko.properties, menu_en.properties, menu_ja.properties<br/>
다음과 같이 프로퍼터즈 파일을 선언한다.<br/>
<fmt:setBundle basename="test"/>
다음과 같이 프로퍼티즈 파일에 사용한 키를 적용합니다.<br/>
<h2><fmt:message key="TITLE"/></h2>
<fmt:message key="FIRST"/><br/>
<fmt:message key="SECOND"/><br/>
<h2><fmt:message key="THIRD"/></h2>
</body>
</html>















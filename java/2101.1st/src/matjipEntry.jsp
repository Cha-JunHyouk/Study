<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>맛집 정보 입력</h2>
<form action="matjipPost.jsp" method="post">
번 호 : <input type="text" name="ID" size="4"/><br/>
이 름 : <input type="text" name="NAME" size="20"/><br/>
주 소 : <input type="text" name="ADDR" size="30"/><br/>
연락처 : <input type="text" name="TEL" size="15"/><br/>
메뉴 종류 : 한식<input type="radio" name="MENU" value="K"/>,
중식<input type="radio" name="MENU" value="C"/>,
양식<input type="radio" name="MENU" value="A"/>,
일식<input type="radio" name="MENU" value="J"/>,
분식<input type="radio" name="MENU" value="M"/>,
기타<input type="radio" name="MENU" value="E"/><br/>
소 개 : <br/>
<textarea rows="8" cols="40" name="INTRO"></textarea><br/>
<input type="submit" value=" 등록 "/>
<input type="reset" value=" 취소 "/>
</form>
</div>
</body>
</html>










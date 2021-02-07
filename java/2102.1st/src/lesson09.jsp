<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">자바스크립트로 브라우저 제어</h2>
<script type="text/javascript">
var popupX = (window.screen.availWidth / 2) - (500 / 2);
var popupY = (window.screen.availHeight / 2) - (300 / 2);
function openSamePopup(){
	window.open("http://www.naver.com","custom_window",
	"width=500, height=300, location=no, status=no, menubar=no,"+
	"scrollbars=no, left=350, top=50,resizable=no");
	//window.open(1,2,3); 1인자:창의 내용, 2인자:이 창의 이름,
	//3인자:가로세로길이, 창의 메뉴,스크롤바,,,창이 출력되는 좌표,,,
}
function openNewPopup(){
	window.open("http://www.naver.com","",
	"width=500, height=300, location=yes, status=yes,menubar=yes"+
	"scrollbars=yes, left=350, top=50");
}
function openPopup(page){
	window.open(page,'','width=500, height=300');
}
function showLocation(){
	document.write("URL주소:"+location.href+"<br/>");
	document.write("호스트 이름과 주소:"+location.host+"<br/>");
	document.write("호스트 컴퓨터이름:"+location.hostname+"<br/>");
	document.write("포트번호:"+location.port+"<br/>");
	document.write("프로토콜:"+location.protocol+"<br/>");
}
function goGoogle(){
	if(confirm("정말로 구글로 이동하시겠습니까?")){
		location.href="http://www.google.com";
	}
}
function goReload(){
	window.open('./lesson9/reload.jsp','rand','width=350,height=300');
}
function showBrowser(){
	document.write("브라우저 이름:"+navigator.appName+"<br/>");
	document.write("브라우저 코드이름:"+navigator.appCodeName+"<br/>");
	document.write("시스템 환경:"+navigator.platform+"<br/>");
	document.write("브라우저 종류와 정보:"+navigator.userAgent+"<br/>");
	document.write("브라우저 버전:"+navigator.appVersion+"<br/>");
}
function findBrowser(){
	var info = navigator.userAgent.toLowerCase();
	if(info.indexOf("chrome") != -1){
		return "크롬";
	}else if(info.indexOf("opera") != -1){
		return "오페라";
	}else if(info.indexOf("firefox") != -1){
		return "파이어 폭스";
	}else if(info.indexOf("safari") != -1){
		return "사파리";
	}else if(info.indexOf("trident") != -1){
		return "익스플로러";
	}else if(info.indexOf("netscape") != -1){
		return "넷스케이프";
	}
}
function getBrowserName(){
	document.write("브라우저의 종류는 "+findBrowser()+"입니다.<br/>");
}
function displayInfo(){
	document.write("디스플레이 높이:"+screen.availHeight+"<br/>");
	document.write("디스플레이 넓이:"+screen.availWidth+"<br/>");
	document.write("색상 bit수:"+screen.colorDepth+"<br/>");
	document.write("픽셀당 bit수:"+screen.pixelDepth+"<br/>");
	var center=[parseInt(screen.availWidth/2),
		parseInt(screen.availHeight /2)];
	document.write("디스플레이의 중심:"+center[0]+","+center[1]+"<br/>");
}
</script>
<a href="#" onClick="openSamePopup();">창열기(한번만 열림)</a><br/>
<a href="#" onClick="openNewPopup();">창열기(매번 다른창 열림)</a><br/>
<a href="#" onClick="openPopup('./lesson9/popup.jsp');">팝업 페이지 열기</a><br/>
<a href="#" onClick="openPopup('http://www.google.com');">구글열기</a><br/>
<a href="#" onClick="showLocation();">location객체 정보 보기</a><br/>
<a href="#" onClick="goGoogle();">구글로 이동</a><br/>
<input type="button" value="구글로 이동" onClick="goGoogle()"/><br/>
<input type="button" value="암호 받기" onClick="goReload()"/><br/>
<a href="./lesson9/forward.jsp">페이지 이동</a><br/>
<a href="#" onClick="history.forward()">앞으로 이동</a><br/>
<input type="button" value="브라우저 정보" onClick="showBrowser()"/><br/>
<input type="button" value="브라우저 종류" onClick="getBrowserName()"/><br/>
<input type="button" value="디스플레이 정보" onClick="displayInfo()"/><br/>
</body>
</html>






















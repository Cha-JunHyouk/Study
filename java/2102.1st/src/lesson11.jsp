<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body onload="showInform()">
<script type="text/javascript">
/*
	JSON(JavaScript Object Notation):자바스크립트에서 자료표현방식
	표현방식은 키와 값의 쌍으로 객체에 저장된다.
 	키는 알파벳으로 시작, 값은 상관없음
 	문법:
 	var 변수이름 = {키:값, 키:값, 키:값,,,};
 */
function showInform(){
	 var information = {
			 "company":"(주)우리집",//키:값
			 "since" : 2000,//키:값
			 "manager" : "홍길동",//키:값
			 "address" : "서울시 송파구",//키:값
			 "items" : ["의류","소품","신발"]//키:값
	 };//JSON객체
	 document.getElementById("company").innerHTML = information.company;
	 document.getElementById("since").innerHTML = information.since;
	 var sellingItems = "";
	 for(var i=0; i<information.items.length; i++){
		 sellingItems = sellingItems+"<li>"+information.items[i]+"</li>";
	 }
	 document.getElementById("items").innerHTML = sellingItems;
	 document.getElementById("manager").innerHTML = information.manager;
	 document.getElementById("address").innerHTML = information.address;
 }
function nestedJson(){
	var hotSales = {
			"J":{"sales":12345, "item":"보온장갑"},//json객체
			"F":{"sales":10304, "item":"보온조끼"}//json객체
	};//json객체	 
	var result = "1월 판매액:"+hotSales.J.sales+",상품명:"+
							hotSales.J.item+"<br/>";
	result = result+"2월 판매액:"+hotSales.F.sales+",상품명:"+
							hotSales.F.item+"<br/>";
	document.getElementById("ranking").innerHTML = result;
}
function newArrival(){
	var cinema = {
		"name":"자바 시네마",
		"history":"2000년에 개장된 영화관으로, 독특한 서비스를 제공하는"+
					"새로운 개념의 영화관입니다.",
		"location":"서울시 송파구",
		"seats":500,
		"movies":[
			{	"title":"바람의 검심","actor":"토마스 조이",
				"director":"제임스 듀이","date":"2010/10/03"	},//json객체
			{	"title":"치히로의 행불","actor":"심형래",
				"director":"제임스 카메론","date":"2010/10/05"},//json객체
			{	"title":"날으는 양탄자","actor":"미스터 도일",
				"director":"코난 도일","date":"2010/10/11"}//json객체
		]//배열
	};//json객체
	var html="<h1 align='center'>"+cinema.name+"</h1>";
	html=html+"<h2 align='center'>연혁:"+cinema.history+"</h2>";
	html=html+"<h2 align='center'>위치:"+cinema.location+"</h2>";
	html=html+"<h2 align='center'>신작</h2>";
	html=html+"<table align='center'>";
	for(var i=0; i<cinema.movies.length; i++){
		var movie = cinema.movies[i];
		html=html+"<tr><td>영화제목:"+cinema.movies[i].title+",주연:"+
			movie.actor+",감독:"+movie.director+",상영일:"+movie.date+
			"</td></tr>";
	}
	html=html+"</table>";
	document.getElementById("info").innerHTML = html;
}
var myown = {
		"blue":"#00f",
		"red":"#f00",
		"korea":function(){
			document.getElementById("lang").innerHTML = 
				"<h3>안녕하세요</h3>";
			document.getElementById("lang").style.color = this.blue;
		},
		"america":function(){
			document.getElementById("lang").innerHTML = 
				"<h3>Hello, Everyone</h3>";
			document.getElementById("lang").style.color = this.red;
		}
};//json객체
</script>
<h1 id="company"></h1>
<p><strong>서비스 시작년도:</strong><span id="since"></span></p>
<h2>보유품목</h2>
<ul id="items"></ul>
<h2>관리자 성명</h2>
<div id="manager"></div>
<h2>주 소</h2>
<div id="address"></div>
<h2>월별 판매 랭킹</h2>
<input type="button" value="결과 보기" onClick="nestedJson()"/><br/>
<div id="ranking"></div><br/>

<input type="button" value="신작 영화 소개" onClick="newArrival()"/><br/>
<div id="info"></div><br/>

<input type="button" value="한글인사" onClick="myown.korea()"/><br/>
<input type="button" value="영어인사" onClick="myown.america()"/><br/>
<div id="lang"></div>
</body>
</html>




















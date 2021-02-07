<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">자바 스크립트에서 날짜 처리</h2>
<script type="text/javascript">
var current = new Date();
var currYear = current.getFullYear();
var currMonth = current.getMonth() + 1;
var currDate = current.getDate();
var currDateStr = currYear+"-"+currMonth+"-"+currDate;
document.write("오늘의 날짜:"+currDateStr+"<br/>");
var days = ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"];
var ist = current.getDay();
document.write("오늘의 요일:"+days[ist]+"<br/>");
var hour = current.getHours();
var min = current.getMinutes();
var sec = current.getSeconds();
var currTime = hour+":"+min+":"+sec;
document.write("현재 시각:"+currTime+"<br/>");

var past = new Date();
past.setYear(2010);
past.setMonth(0);//1월
past.setDate(20);
past.setHours(13);//오후1시
past.setMinutes(30);
past.setSeconds(30);
var pastYear = past.getFullYear();
var pastMonth = past.getMonth() + 1;
var pastDate = past.getDate();
var pst = past.getDay();
var pastDay = days[pst];
var pastHour = past.getHours();
var pastMin = past.getMinutes();
var pastSec = past.getSeconds();
var pastDateStr = pastYear+"-"+pastMonth+"-"+pastDate+" "+pastDay+" "+
		pastHour+":"+pastMin+":"+pastSec;
document.write("과거의 어느날:"+pastDateStr+"<br/>");
var someDay = new Date(2002,2,2);
var pastDays = current.getTime() - someDay.getTime();
var spentDays = Math.floor(pastDays / (24 * 60 * 60 * 1000));
document.write("2002년 2월 2일 부터 오늘까지 지난 날:"+spentDays+"<br/>");

function workingClock(){
	var days=["일","월","화","수","목","금","토"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	if(month < 10) month = "0"+month;
	var date = today.getDate();
	if(date < 10) date = "0"+date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10) min = "0"+min;
	var sec = today.getSeconds();
	if(sec < 10) sec = "0"+sec;
	var str=year+"-"+month+"-"+date+" "+day+" "+hour+":"+min+":"+sec;
	document.getElementById("clock").innerHTML = str;
}
function startClock(){
	setInterval(workingClock, 1000);//1초마다 workingClock함수 호출
}
</script>
<a href="#" onClick="javascript:startClock()">시계보이기</a>
<div id="clock"></div>
</body>
</html>



























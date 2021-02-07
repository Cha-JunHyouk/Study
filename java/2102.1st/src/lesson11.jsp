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
	JSON(JavaScript Object Notation):�ڹٽ�ũ��Ʈ���� �ڷ�ǥ�����
	ǥ������� Ű�� ���� ������ ��ü�� ����ȴ�.
 	Ű�� ���ĺ����� ����, ���� �������
 	����:
 	var �����̸� = {Ű:��, Ű:��, Ű:��,,,};
 */
function showInform(){
	 var information = {
			 "company":"(��)�츮��",//Ű:��
			 "since" : 2000,//Ű:��
			 "manager" : "ȫ�浿",//Ű:��
			 "address" : "����� ���ı�",//Ű:��
			 "items" : ["�Ƿ�","��ǰ","�Ź�"]//Ű:��
	 };//JSON��ü
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
			"J":{"sales":12345, "item":"�����尩"},//json��ü
			"F":{"sales":10304, "item":"��������"}//json��ü
	};//json��ü	 
	var result = "1�� �Ǹž�:"+hotSales.J.sales+",��ǰ��:"+
							hotSales.J.item+"<br/>";
	result = result+"2�� �Ǹž�:"+hotSales.F.sales+",��ǰ��:"+
							hotSales.F.item+"<br/>";
	document.getElementById("ranking").innerHTML = result;
}
function newArrival(){
	var cinema = {
		"name":"�ڹ� �ó׸�",
		"history":"2000�⿡ ����� ��ȭ������, ��Ư�� ���񽺸� �����ϴ�"+
					"���ο� ������ ��ȭ���Դϴ�.",
		"location":"����� ���ı�",
		"seats":500,
		"movies":[
			{	"title":"�ٶ��� �˽�","actor":"�丶�� ����",
				"director":"���ӽ� ����","date":"2010/10/03"	},//json��ü
			{	"title":"ġ������ ���","actor":"������",
				"director":"���ӽ� ī�޷�","date":"2010/10/05"},//json��ü
			{	"title":"������ ��ź��","actor":"�̽��� ����",
				"director":"�ڳ� ����","date":"2010/10/11"}//json��ü
		]//�迭
	};//json��ü
	var html="<h1 align='center'>"+cinema.name+"</h1>";
	html=html+"<h2 align='center'>����:"+cinema.history+"</h2>";
	html=html+"<h2 align='center'>��ġ:"+cinema.location+"</h2>";
	html=html+"<h2 align='center'>����</h2>";
	html=html+"<table align='center'>";
	for(var i=0; i<cinema.movies.length; i++){
		var movie = cinema.movies[i];
		html=html+"<tr><td>��ȭ����:"+cinema.movies[i].title+",�ֿ�:"+
			movie.actor+",����:"+movie.director+",����:"+movie.date+
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
				"<h3>�ȳ��ϼ���</h3>";
			document.getElementById("lang").style.color = this.blue;
		},
		"america":function(){
			document.getElementById("lang").innerHTML = 
				"<h3>Hello, Everyone</h3>";
			document.getElementById("lang").style.color = this.red;
		}
};//json��ü
</script>
<h1 id="company"></h1>
<p><strong>���� ���۳⵵:</strong><span id="since"></span></p>
<h2>����ǰ��</h2>
<ul id="items"></ul>
<h2>������ ����</h2>
<div id="manager"></div>
<h2>�� ��</h2>
<div id="address"></div>
<h2>���� �Ǹ� ��ŷ</h2>
<input type="button" value="��� ����" onClick="nestedJson()"/><br/>
<div id="ranking"></div><br/>

<input type="button" value="���� ��ȭ �Ұ�" onClick="newArrival()"/><br/>
<div id="info"></div><br/>

<input type="button" value="�ѱ��λ�" onClick="myown.korea()"/><br/>
<input type="button" value="�����λ�" onClick="myown.america()"/><br/>
<div id="lang"></div>
</body>
</html>




















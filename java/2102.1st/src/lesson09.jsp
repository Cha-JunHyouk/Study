<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�ڹٽ�ũ��Ʈ�� ������ ����</h2>
<script type="text/javascript">
var popupX = (window.screen.availWidth / 2) - (500 / 2);
var popupY = (window.screen.availHeight / 2) - (300 / 2);
function openSamePopup(){
	window.open("http://www.naver.com","custom_window",
	"width=500, height=300, location=no, status=no, menubar=no,"+
	"scrollbars=no, left=350, top=50,resizable=no");
	//window.open(1,2,3); 1����:â�� ����, 2����:�� â�� �̸�,
	//3����:���μ��α���, â�� �޴�,��ũ�ѹ�,,,â�� ��µǴ� ��ǥ,,,
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
	document.write("URL�ּ�:"+location.href+"<br/>");
	document.write("ȣ��Ʈ �̸��� �ּ�:"+location.host+"<br/>");
	document.write("ȣ��Ʈ ��ǻ���̸�:"+location.hostname+"<br/>");
	document.write("��Ʈ��ȣ:"+location.port+"<br/>");
	document.write("��������:"+location.protocol+"<br/>");
}
function goGoogle(){
	if(confirm("������ ���۷� �̵��Ͻðڽ��ϱ�?")){
		location.href="http://www.google.com";
	}
}
function goReload(){
	window.open('./lesson9/reload.jsp','rand','width=350,height=300');
}
function showBrowser(){
	document.write("������ �̸�:"+navigator.appName+"<br/>");
	document.write("������ �ڵ��̸�:"+navigator.appCodeName+"<br/>");
	document.write("�ý��� ȯ��:"+navigator.platform+"<br/>");
	document.write("������ ������ ����:"+navigator.userAgent+"<br/>");
	document.write("������ ����:"+navigator.appVersion+"<br/>");
}
function findBrowser(){
	var info = navigator.userAgent.toLowerCase();
	if(info.indexOf("chrome") != -1){
		return "ũ��";
	}else if(info.indexOf("opera") != -1){
		return "�����";
	}else if(info.indexOf("firefox") != -1){
		return "���̾� ����";
	}else if(info.indexOf("safari") != -1){
		return "���ĸ�";
	}else if(info.indexOf("trident") != -1){
		return "�ͽ��÷η�";
	}else if(info.indexOf("netscape") != -1){
		return "�ݽ�������";
	}
}
function getBrowserName(){
	document.write("�������� ������ "+findBrowser()+"�Դϴ�.<br/>");
}
function displayInfo(){
	document.write("���÷��� ����:"+screen.availHeight+"<br/>");
	document.write("���÷��� ����:"+screen.availWidth+"<br/>");
	document.write("���� bit��:"+screen.colorDepth+"<br/>");
	document.write("�ȼ��� bit��:"+screen.pixelDepth+"<br/>");
	var center=[parseInt(screen.availWidth/2),
		parseInt(screen.availHeight /2)];
	document.write("���÷����� �߽�:"+center[0]+","+center[1]+"<br/>");
}
</script>
<a href="#" onClick="openSamePopup();">â����(�ѹ��� ����)</a><br/>
<a href="#" onClick="openNewPopup();">â����(�Ź� �ٸ�â ����)</a><br/>
<a href="#" onClick="openPopup('./lesson9/popup.jsp');">�˾� ������ ����</a><br/>
<a href="#" onClick="openPopup('http://www.google.com');">���ۿ���</a><br/>
<a href="#" onClick="showLocation();">location��ü ���� ����</a><br/>
<a href="#" onClick="goGoogle();">���۷� �̵�</a><br/>
<input type="button" value="���۷� �̵�" onClick="goGoogle()"/><br/>
<input type="button" value="��ȣ �ޱ�" onClick="goReload()"/><br/>
<a href="./lesson9/forward.jsp">������ �̵�</a><br/>
<a href="#" onClick="history.forward()">������ �̵�</a><br/>
<input type="button" value="������ ����" onClick="showBrowser()"/><br/>
<input type="button" value="������ ����" onClick="getBrowserName()"/><br/>
<input type="button" value="���÷��� ����" onClick="displayInfo()"/><br/>
</body>
</html>






















<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�ڹٽ�ũ��Ʈ�� Math Ŭ���� ���</h2>
<script type="text/javascript">
var max = Math.max(123, 456, 789, 999);
document.write("<h3>�ִ밪:"+max+"</h3>");
var min = Math.min(123, 456, 789);
document.write("<h3>�ּҰ�:"+min+"</h3>");
document.write("<h3>������:"+Math.PI+"</h3>");
var value = 3.14159265;
document.write("<h3>�ݿø�:"+Math.round(value)+"</h3>");
document.write("<h3>�ø�:"+Math.ceil(value)+"</h3>");
document.write("<h3>����:"+Math.floor(value)+"</h3>");
var worth = -3.14159265;
document.write("<h3>���밪:"+Math.abs(worth)+"</h3>");
document.write("<h3>����:"+Math.random()+"</h3>");
var rnd = parseInt((Math.random()*10)+1);
document.write("<h3>1���� 10���� ����:"+rnd+"</h3>");
function makerandom(from,to){
	return parseInt((Math.random()*(to-from+1))+from);
}
var rand = "";
for(var i=0; i<5; i++){
	rand = rand + makerandom(0,9);
}
document.write("<h3>�ټ��ڸ� ������ ��:"+rand+"</h3>");
</script>
</body>
</html>








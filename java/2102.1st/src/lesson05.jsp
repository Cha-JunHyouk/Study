<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�ڹٽ�ũ��Ʈ���� ���ڿ� ó��</h2>
<script type="text/javascript">
var strr = new String("�ڹٽ�ũ��Ʈ");
var str = "http://java.sun.com/INDEX.jsp";
document.write("���ڿ� : "+strr+"<br/>");
var length = str.length;
document.write("���ڿ� ���� : "+length+"<br/>");
var strat5 = str.charAt(5);
document.write("������° ���� : "+strat5+"<br/>");
var index = str.indexOf("/");
document.write("���ڿ����� /�� ��ġ : "+index+"<br/>");
var afterIndex = str.indexOf("/", index+1);
document.write("�ι�° /�� ��ġ : "+afterIndex+"<br/>");
var lastSlash = str.lastIndexOf("/");
document.write("�ڿ��� ���� /�� ��ġ : "+lastSlash+"<br/>");
var str04 = str.substring(0,4);
document.write("ù��° ���ں��� �׹�° ���ڱ��� : "+str04+"<br/>");
var str711 = str.substring(7,11);
document.write("������° ���ں��� ���ѹ��� ���ڱ��� :"+str711+"<br/>");
var strfile = str.substring(20);
document.write("21��° ���ں��� ������ : "+strfile+"<br/>");
var upper = strfile.toUpperCase();
document.write("�����̸��� �빮�ڷ� : "+upper+"<br/>");
var lower = strfile.toLowerCase();
document.write("�����̸��� �ҹ��ڷ� : "+lower+"<br/>");
var start = str.indexOf("://");
var end = str.indexOf("/", start+3);
var domain = str.substring(start+3, end);
document.write("������ �̸� : "+domain+"<br/>");
var filefrom = str.lastIndexOf("/");
var fileto = str.lastIndexOf(".");
var filename = str.substring(filefrom+1, fileto);
document.write("�����̸� : "+filename+"<br/>");
var ext = str.substring(fileto + 1);
document.write("Ȯ���� : "+ext+"<br/>");
</script>
</body>
</html>











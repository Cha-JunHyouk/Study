<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
while(true){
	var score = prompt("������ �Է��ϼ���.");
	var isString = isNaN(score);
	if( ! isString ){
		switch(parseInt(score/10)){
		case 10:
		case 9: document.write("<h2 align='center'>A����</h2>");break;
		case 8: document.write("<h2 align='center'>B����</h2>");break;
		case 7: document.write("<h2 align='center'>C����</h2>");break;
		case 6: document.write("<h2 align='center'>D����</h2>");break;
		default :document.write("<h2 align='center'>F����</h2>");break;
		}
		break;//�ݺ� ����
	}else{
		alert("���ڸ� �Է��ؾ� �մϴ�.");
	}
}
hello1();
function hello1(){
	document.write("<h2 align='center'>�ڹ� ��ũ��Ʈ �Դϴ�.</h2>");
}
function hello2(str){
	document.write("<h2 align='center'>"+str+"�� �޾ҽ��ϴ�.</h2>");
}
function calculate(str){
	if(isNaN(str)){
		document.write("���ڿ� "+str+"�� �޾ҽ��ϴ�.<br/>");
		document.write("������ ���ڸ���� ���ڿ��� ����� �� �� �ֽ��ϴ�.");
		document.write("<br/>��� ����� "+eval(str)+"�Դϴ�.");
	}
}
hello2("�ڹ� ��ũ��Ʈ");
calculate("3+5");
</script>
</body>
</html>







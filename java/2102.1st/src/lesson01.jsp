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
alert("alertâ�Դϴ�.");
var is = confirm("confirmâ�Դϴ�.");
if(is == true){
	alert("���� ��ư�� �������ϴ�.");
}else {
	alert("���� ��ư�� �������ϴ�.");
}
var input = prompt("�ƹ� ���̳� �Է��ϼ���.");
alert(input+"�� �Է��ϼ̽��ϴ�.");
var isNumber = isNaN(input);
if(isNumber == true){
	alert("���ڸ� �Է��߽��ϴ�.");
}else {
	alert("���ڸ� �Է��߽��ϴ�.");
	var num = input;
	var sum = 0;
	for(var i=1; i<= num; i++){//1���� �Է��� �� ���� �ݺ�
		sum = sum + i;
	}
	alert("1 ���� "+num+"������ ���� "+sum+"�Դϴ�.for�� �����");
	sum = 0;
	var cnt = 1;
	while(cnt <= num){
		sum = sum + cnt;
		cnt++;
	}
	alert("1 ���� "+num+"������ ���� "+sum+"�Դϴ�.while�� �����.");
	sum = 0;
	cnt = 1;
	do{
		sum = sum + cnt;
		cnt++;
	}while(cnt <= num);
	alert("1 ���� "+num+"������ ���� "+sum+"�Դϴ�.do-while�� �����.");
}
alert("�������� ���̺�� �������� ����մϴ�.");
document.write("<h1 align='center'>������</h1><br/><br/>");
document.write("<table width='100%' border='1' text-align='center'>");
for(var dan=1; dan<=9; dan++){
		document.write("<tr>");
		for(var su=1; su<=9; su++){
			var txt = dan+" * "+su+" = "+(dan * su);
			document.write("<td>"+txt+"</td>");
		}
		document.write("</tr>");
}
document.write("</table>");
</script>
</body>
</html>
















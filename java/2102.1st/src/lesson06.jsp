<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�ڹٽ�ũ��Ʈ���� �迭ó��</h2>
<script type="text/javascript">
var array1 = new Array("�ڹ�1","�ڹٽ�ũ��Ʈ1","����1");
var array2 = ["�ڹ�2","�ڹٽ�ũ��Ʈ2","����2"];
document.write(array1[1]+"<br/>");
document.write(array2[1]+"<br/>");
var array3 = new Array();
var array4 = [];
array3[0]="�ڹ�3"; array3[1]="�ڹٽ�ũ��Ʈ3"; array3[2]="����3";
array4[0]="�ڹ�4"; array4[1]="�ڹٽ�ũ��Ʈ4"; array4[2]="����4";
document.write(array3[1]+" �迭�� ����:"+array3.length+"<br/>");
document.write(array4[1]+" �迭�� ����:"+array4.length+"<br/>");

var array5 = new Array(
	new Array("�ڹ�11","�ڹٽ�ũ��Ʈ12","����13"),
	new Array("�ڹ�21","�ڹٽ�ũ��Ʈ22","����23")
);
var array6 = [
	["�ڹ�1_1","�ڹٽ�ũ��Ʈ1_2","����1_3"],
	["�ڹ�2_1","�ڹٽ�ũ��Ʈ2_2","����2_3"]
];
document.write(array5[0][0]+" ���� ����:"+array5.length+"���� ����:"+
		array5[0].length+"<br/>");
document.write(array6[0][0]+" ���� ����:"+array6.length+"���� ����:"+
		array6[0].length+"<br/>");
var sentence = "�츮��, �ڹٽ�ũ��Ʈ��, �����ϰ�, �ֽ��ϴ�.";
var words = sentence.split(",");
for(var cnt=0; cnt<words.length; cnt++){
	document.write(words[cnt]);
}
</script>
</body>
</html>












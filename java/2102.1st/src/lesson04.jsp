<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�ڹ� ��ũ��Ʈ �Լ��� �ۼ��ϴ� ���</h2>
<script type="text/javascript">
function showSomething(){
	document.write("<h2>�Լ��� ȣ���մϴ�.</h2>");
}
var show = showSomething;
show();
var call = function(){
	document.write("<h2>�Լ��� �� ȣ���մϴ�.</h2>");
}
call();
var person = {};//�ڹٽ�ũ��Ʈ���� ��ü�� �����մϴ�.
person.name = "ȫ�浿";
person.address = "����� ���ı�";
person.showName = function(){
	document.write("<h2>"+person.name+"</h2>");
};
person.showAddress = function(){
	document.write("<h2>"+person.address+"</h2>");
};
person.age = 32;
person.showAge = function(){
	return this.age;
};
document.write("<h2>�̸��� �ּ�:"+person.name+","+person.address+"</h2>");
person.showName();
person.showAddress();
document.write("<h2>����:"+person.showAge()+"</h2>");
person.showTitle = function(title){
	document.write("<h2>"+title+"</h2>");
}
person.showTitle("�ڹ� ��ũ��Ʈ�� �����մϴ�.");

var operation = {};//�ڹ� ��ũ��Ʈ ��ü ����
operation.x = 0; operation.y = 0;
operation.setValue = function(n1, n2){
	this.x = n1; this.y = n2;
};
operation.add = function(n1, n2){
	operation.setValue(n1, n2);
	return this.x + this.y;
};
operation.sub = function(n1, n2){
	operation.setValue(n1, n2);
	return this.x - this.y;
};
operation.mul = function(n1, n2){
	operation.setValue(n1, n2);
	return this.x * this.y;
};
operation.div = function(n1, n2){
	operation.setValue(n1, n2);
	return this.x / this.y;
};
operation.doIt = function(n1, n2){
	var r1 = this.add(n1,n2); var r2 = this.sub(n1,n2);
	var r3 = this.mul(n1,n2); var r4 = this.div(n1,n2);
	document.write("<h2>������ ���:"+r1+"</h2>");
	document.write("<h2>������ ���:"+r2+"</h2>");
	document.write("<h2>������ ���:"+r3+"</h2>");
	document.write("<h2>�������� ���:"+r4+"</h2>");
};
operation.doIt(3,6);
</script>
</body>
</html>

















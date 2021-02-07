<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>자바 스크립트 함수를 작성하는 방법</h2>
<script type="text/javascript">
function showSomething(){
	document.write("<h2>함수를 호출합니다.</h2>");
}
var show = showSomething;
show();
var call = function(){
	document.write("<h2>함수를 또 호출합니다.</h2>");
}
call();
var person = {};//자바스크립트에서 객체를 선언합니다.
person.name = "홍길동";
person.address = "서울시 송파구";
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
document.write("<h2>이름과 주소:"+person.name+","+person.address+"</h2>");
person.showName();
person.showAddress();
document.write("<h2>나이:"+person.showAge()+"</h2>");
person.showTitle = function(title){
	document.write("<h2>"+title+"</h2>");
}
person.showTitle("자바 스크립트를 공부합니다.");

var operation = {};//자바 스크립트 객체 선언
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
	document.write("<h2>덧셈의 결과:"+r1+"</h2>");
	document.write("<h2>뺄셈의 결과:"+r2+"</h2>");
	document.write("<h2>곱셈의 결과:"+r3+"</h2>");
	document.write("<h2>나눗셈의 결과:"+r4+"</h2>");
};
operation.doIt(3,6);
</script>
</body>
</html>

















<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {border:10px solid red;}
.square {margin:10px auto; border:5px solid #0cc; 
			padding:30px; text-align:center;}
.block {margin:10px auto; border:10px solid #f0f;
		background-color: #ff0; padding:25px; text-align:right;}	
.images {padding:0; margin:0; list-style:none; width:120px; float:left;}
.images li {width:100px; height:100px; padding:5px 10px;}	
.images img {width:100px; height:100px;}
.display {float:left; width:500px; height:320px; padding:5px 0;}
.display img {width:500px; height:320px;}	

ul{padding:0; margin:0; width:670px; list-style:none;}
h1{clear:both;}
li{float:left;}

.group { height:42px; border-bottom:1px dashed #0cc;}
.group label {width:100px; display:inline-block;}
</style>
</head>
<body>
<script type="text/javascript">
function tableColor(color){
	var attr = "10px solid "+color;
	document.getElementById("tbl").style.border = attr;
	document.getElementById("row").style.offsetHeight = 200;
	//offsetHeight는 경계선을 포함한 높이
}
function setFontColor(color){
	var box = document.getElementById("box");
	box.style.color = color;
}
function setBgColor(color){
	document.getElementById("box").style.backgroundColor = color;
}
function setWidth(width){
	document.getElementById("box").style.width = width;
}
function changeClass(name){
	document.getElementById("box").className = name;
}
function setImage(order){
	var images = ["imgs/kiwi.jpg","imgs/lemon.jpg","imgs/orange.jpg"];
	var image = document.getElementById("target");
	image.src = images[order];
}
function changeMenu(name, image){
	document.getElementById(name).src = image;
}
function doIt(){
	var frm = document.personal;
	if(frm.user_name.value == ''){
		alert("이름을 입력하세요.");		frm.user_name.focus();
		return false;
	}
	if(!frm.gender[0].checked && !frm.gender[1].checked){
		alert("성별을 선택하세요.");	frm.gender[0].focus(); return false;
	}
	if(frm.job.selectedIndex < 1){
		alert("직업을 선택하세요."); frm.job.focus(); return false;
	}
	var flag = false;
	for(var i=0; i<frm.HOBBY.length; i++){
		if(frm.HOBBY[i].checked){
			flag = true;		break;
		}
	}//모든 체크박스를 검사해서 체크가 되어있는지 검사한다.
	if(!flag){
		alert("취미를 선택하세요."); frm.HOBBY[0].focus(); return false;
	}
	if(confirm("입려하신 내용이 맞습니까?")){
		frm.submit();
	}else {
		return false;
	}
}
function doReset(){
	document.personal.reset();
}
</script>
<input type="button" value="테이블 색변경" onClick="tableColor('blue')"/><br/>
<table id="tbl">
	<tr id="row" height="100"><td>테이블</td></tr>
</table>
<h1 align="center">스타일을 제어합니다.</h1>
<div id="box" class="square">
	<h2>여기에 나타납니다.</h2>
</div>
<input type="button" value="글자색(적색)" onClick="setFontColor('#f00')"/>
<input type="button" value="글자색(녹색)" onClick="setFontColor('#0f0')"/>
<input type="button" value="글자색(청색)" onClick="setFontColor('#00f')"/>
<br/>
<input type="button" value="배경색(적색)" onClick="setBgColor('#f00')"/>
<input type="button" value="배경색(녹색)" onClick="setBgColor('#0f0')"/>
<input type="button" value="배경색(청색)" onClick="setBgColor('#00f')"/>
<br/>
<input type="button" value="가로변경(50%)" onClick="setWidth('50%')"/>
<input type="button" value="가로변경(auto)" onClick="setWidth('auto')"/>
<br/>
<input type="button" value="square클래스 적용" 
				onClick="changeClass('square')"/>
<input type="button" value="block클래스 적용"
				onClick="changeClass('block')"/><br/>
<h1 align="center">이미지를 제어합니다.</h1>
<ul class="images">
	<li><a href="#" onClick="setImage(0)"><img alt="" src="imgs/kiwi.jpg">
		</a></li>
	<li><a href="#" onClick="setImage(1)"><img alt="" src="imgs/lemon.jpg">
		</a></li>
	<li><a href="#" onClick="setImage(2)"><img alt="" src="imgs/orange.jpg">
		</a></li>
</ul>
<div class="display">
	<img alt="" src="imgs/lemon.jpg" id="target">
</div><br/>
<h1 align="center">메뉴를 제어합니다.</h1>
<ul id="menu">
	<li><a href="#" onMouseOver="changeMenu('1','imgs/but_a0005c.gif')"
			onMouseOut="changeMenu('1','imgs/but_a0005b.gif')">
			<img alt="" src="imgs/but_a0005b.gif" id="1"></a></li>
	<li><a href="#" onMouseOver="changeMenu('2','imgs/but_a0006c.gif')"
			onMouseOut="changeMenu('2','imgs/but_a0006b.gif')">
			<img alt="" src="imgs/but_a0006b.gif" id="2"></a></li>
	<li><a href="#" onMouseOver="changeMenu('3','imgs/but_a0007c.gif')"
			onMouseOut="changeMenu('3','imgs/but_a0007b.gif')">
			<img alt="" src="imgs/but_a0007b.gif" id="3"></a></li>
	<li><a href="#" onMouseOver="changeMenu('4','imgs/but_a0010c.gif')"
			onMouseOut="changeMenu('4','imgs/but_a0010b.gif')">
			<img alt="" src="imgs/but_a0010b.gif" id="4"></a></li>
</ul>	
<h1 align="center">입력폼을 제어합니다.</h1>
<form action="" name="personal" onSubmit="doIt(); return false;">
<fieldset>
	<legend>회원 정보</legend>
	<div class="group">
		<label>이름</label><input type="text" name="user_name"/>	</div>
	<div class="group">
		<label>성별</label>
		<label><input type="radio" name="gender" value="M">남자</label>
		<label><input type="radio" name="gender" value="F">여자</label>
	</div>
	<div class="group">
		<label>직업</label>
		<select name="job">
			<option>--선택하세요--</option>
			<option value="STU">학생</option>
			<option value="EMP">회사원</option>
			<option value="HUS">주부</option>
			<option value="ETC">기타</option>
		</select></div>
	<div class="group">
		<label>취미</label>
<label><input type="checkbox" name="HOBBY" value="GAME"/>게임</label>
<label><input type="checkbox" name="HOBBY" value="SING"/>노래부르기</label>
		<label><input type="checkbox" name="HOBBY" value="GYM"/>운동</label>
	</div>
	<div class="group">
		<label>&nbsp;</label>
		<input type="submit" name="BUTTON" value="전송하기"/>
		<input type="button" value="취소" onClick="doReset()"/>
		<input type="reset" value="취소"/>
	</div>
</fieldset>
</form>		
</body>
</html>






















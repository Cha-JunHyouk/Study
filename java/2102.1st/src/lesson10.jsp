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
	//offsetHeight�� ��輱�� ������ ����
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
		alert("�̸��� �Է��ϼ���.");		frm.user_name.focus();
		return false;
	}
	if(!frm.gender[0].checked && !frm.gender[1].checked){
		alert("������ �����ϼ���.");	frm.gender[0].focus(); return false;
	}
	if(frm.job.selectedIndex < 1){
		alert("������ �����ϼ���."); frm.job.focus(); return false;
	}
	var flag = false;
	for(var i=0; i<frm.HOBBY.length; i++){
		if(frm.HOBBY[i].checked){
			flag = true;		break;
		}
	}//��� üũ�ڽ��� �˻��ؼ� üũ�� �Ǿ��ִ��� �˻��Ѵ�.
	if(!flag){
		alert("��̸� �����ϼ���."); frm.HOBBY[0].focus(); return false;
	}
	if(confirm("�Է��Ͻ� ������ �½��ϱ�?")){
		frm.submit();
	}else {
		return false;
	}
}
function doReset(){
	document.personal.reset();
}
</script>
<input type="button" value="���̺� ������" onClick="tableColor('blue')"/><br/>
<table id="tbl">
	<tr id="row" height="100"><td>���̺�</td></tr>
</table>
<h1 align="center">��Ÿ���� �����մϴ�.</h1>
<div id="box" class="square">
	<h2>���⿡ ��Ÿ���ϴ�.</h2>
</div>
<input type="button" value="���ڻ�(����)" onClick="setFontColor('#f00')"/>
<input type="button" value="���ڻ�(���)" onClick="setFontColor('#0f0')"/>
<input type="button" value="���ڻ�(û��)" onClick="setFontColor('#00f')"/>
<br/>
<input type="button" value="����(����)" onClick="setBgColor('#f00')"/>
<input type="button" value="����(���)" onClick="setBgColor('#0f0')"/>
<input type="button" value="����(û��)" onClick="setBgColor('#00f')"/>
<br/>
<input type="button" value="���κ���(50%)" onClick="setWidth('50%')"/>
<input type="button" value="���κ���(auto)" onClick="setWidth('auto')"/>
<br/>
<input type="button" value="squareŬ���� ����" 
				onClick="changeClass('square')"/>
<input type="button" value="blockŬ���� ����"
				onClick="changeClass('block')"/><br/>
<h1 align="center">�̹����� �����մϴ�.</h1>
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
<h1 align="center">�޴��� �����մϴ�.</h1>
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
<h1 align="center">�Է����� �����մϴ�.</h1>
<form action="" name="personal" onSubmit="doIt(); return false;">
<fieldset>
	<legend>ȸ�� ����</legend>
	<div class="group">
		<label>�̸�</label><input type="text" name="user_name"/>	</div>
	<div class="group">
		<label>����</label>
		<label><input type="radio" name="gender" value="M">����</label>
		<label><input type="radio" name="gender" value="F">����</label>
	</div>
	<div class="group">
		<label>����</label>
		<select name="job">
			<option>--�����ϼ���--</option>
			<option value="STU">�л�</option>
			<option value="EMP">ȸ���</option>
			<option value="HUS">�ֺ�</option>
			<option value="ETC">��Ÿ</option>
		</select></div>
	<div class="group">
		<label>���</label>
<label><input type="checkbox" name="HOBBY" value="GAME"/>����</label>
<label><input type="checkbox" name="HOBBY" value="SING"/>�뷡�θ���</label>
		<label><input type="checkbox" name="HOBBY" value="GYM"/>�</label>
	</div>
	<div class="group">
		<label>&nbsp;</label>
		<input type="submit" name="BUTTON" value="�����ϱ�"/>
		<input type="button" value="���" onClick="doReset()"/>
		<input type="reset" value="���"/>
	</div>
</fieldset>
</form>		
</body>
</html>






















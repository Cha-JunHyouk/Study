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
function idCheck(){
	if(document.frm.ID.value == ''){
		alert("���̵� �Է��ϼ���.");
		document.frm.ID.focus();
		return;
	}
	var url = "idCheck.do?USER_ID="+document.frm.ID.value;
	window.open(url,"_blank_","width=450,height=200");
}
function formCheck(fm){
	if(fm.NAME.value == ''){
		alert("�̸��� �Է��ϼ���."); fm.NAME.focus(); return false;
	}
	if(fm.idchecked.value == ''){
		alert("���� �ߺ� �˻縦 ���ּ���."); return false;
	}
	if(fm.ID.value == ''){
		alert("������ �Է��ϼ���."); fm.ID.focus(); return false;
	}
	if(fm.ADDR.value == ''){
		alert("�ּҸ� �Է��ϼ���."); fm.ADDR.focus(); return false;
	}
	if(fm.TEL.value == ''){
		alert("����ó�� �Է��ϼ���."); fm.TEL.focus(); return false;
	}
	if(fm.PASSWORD.value == ''){
		alert("��ȣ�� �Է��ϼ���."); fm.PASSWORD.focus(); return false;
	}
	if(fm.PASSWORD.value != fm.CONFIRM.value){
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�.");
		fm.PASSWORD.focus(); return false;
	}
	if( !fm.GENDER[0].checked && !fm.GENDER[1].checked){
		alert("������ �����ϼ���."); fm.GENDER[0].focus(); return false;
	}
	if(fm.JOB.selectedIndex < 1){
		alert("������ �����ϼ���."); fm.JOB.focus(); return false;
	}
	if(confirm("�Է��� ������ �½��ϱ�?")){
		frm.submit(); return false;
	}else { return false; }
}
</script>
<h2 align="center">���� ���� �Է�</h2>
<form action="register" method="post" name="frm"
		onSubmit="return formCheck(this)">
<input type="hidden" name="idchecked"/>
�� �� : <input type="text" name="NAME"/><br/>
�� �� : <input type="text" name="ID"/>
<input type="button" value="�ߺ��˻�" onClick="idCheck()"/><br/>
�� �� : <input type="text" name="ADDR"/><br/>
����ó : <input type="text" name="TEL"/><br/>
�� ȣ : <input type="password" name="PASSWORD"/><br/>
��ȣ Ȯ�� : <input type="password" name="CONFIRM"/><br/><br/>
�� �� : ��<input type="radio" name="GENDER" value="M"/>
��<input type="radio" name="GENDER" value="F"/><br/><br/>
�̸��� : <input type="text" name="EMAIL"/><br/>
�� �� : 
<select name="JOB">
	<option>--�����ϼ���--</option><option>ȸ���</option>
	<option>�л�</option><option>��Ÿ</option>
</select><br/><br/>
<div align="center">
<input type="submit" value="Ȯ��"/><input type="reset" value="���"/></div>
</form>
</body>
</html>












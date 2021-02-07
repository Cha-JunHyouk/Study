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
		alert("아이디를 입력하세요.");
		document.frm.ID.focus();
		return;
	}
	var url = "idCheck.do?USER_ID="+document.frm.ID.value;
	window.open(url,"_blank_","width=450,height=200");
}
function formCheck(fm){
	if(fm.NAME.value == ''){
		alert("이름을 입력하세요."); fm.NAME.focus(); return false;
	}
	if(fm.idchecked.value == ''){
		alert("계정 중복 검사를 해주세요."); return false;
	}
	if(fm.ID.value == ''){
		alert("계정을 입력하세요."); fm.ID.focus(); return false;
	}
	if(fm.ADDR.value == ''){
		alert("주소를 입력하세요."); fm.ADDR.focus(); return false;
	}
	if(fm.TEL.value == ''){
		alert("연락처를 입력하세요."); fm.TEL.focus(); return false;
	}
	if(fm.PASSWORD.value == ''){
		alert("암호를 입력하세요."); fm.PASSWORD.focus(); return false;
	}
	if(fm.PASSWORD.value != fm.CONFIRM.value){
		alert("암호가 일치하지 않습니다.");
		fm.PASSWORD.focus(); return false;
	}
	if( !fm.GENDER[0].checked && !fm.GENDER[1].checked){
		alert("성별을 선택하세요."); fm.GENDER[0].focus(); return false;
	}
	if(fm.JOB.selectedIndex < 1){
		alert("직업을 선택하세요."); fm.JOB.focus(); return false;
	}
	if(confirm("입력한 내용이 맞습니까?")){
		frm.submit(); return false;
	}else { return false; }
}
</script>
<h2 align="center">개인 정보 입력</h2>
<form action="register" method="post" name="frm"
		onSubmit="return formCheck(this)">
<input type="hidden" name="idchecked"/>
이 름 : <input type="text" name="NAME"/><br/>
계 정 : <input type="text" name="ID"/>
<input type="button" value="중복검사" onClick="idCheck()"/><br/>
주 소 : <input type="text" name="ADDR"/><br/>
연락처 : <input type="text" name="TEL"/><br/>
암 호 : <input type="password" name="PASSWORD"/><br/>
암호 확인 : <input type="password" name="CONFIRM"/><br/><br/>
성 별 : 남<input type="radio" name="GENDER" value="M"/>
여<input type="radio" name="GENDER" value="F"/><br/><br/>
이메일 : <input type="text" name="EMAIL"/><br/>
직 업 : 
<select name="JOB">
	<option>--선택하세요--</option><option>회사원</option>
	<option>학생</option><option>기타</option>
</select><br/><br/>
<div align="center">
<input type="submit" value="확인"/><input type="reset" value="취소"/></div>
</form>
</body>
</html>












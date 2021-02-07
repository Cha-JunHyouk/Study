<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">계정 중복 확인</h2>
<form action="idCheck.do" method="get" name="frm">
<input type="hidden" name="OK" value="${ID }"/>
계 정 : <input type="text" name="USER_ID" value="${ID }"/>
<input type="submit" value="중복 검사"/><br/>
<c:if test="${ ! empty DUP }">
	<script type="text/javascript">
		opener.document.frm.ID.value = '';
	</script>
${DUP }는 이미 사용 중입니다.
</c:if>
<c:if test="${ empty DUP }">
${ID }는 사용 가능합니다. 
<input type="button" value="사용" onClick="idOK()"/>
</c:if>
</form>
<script type="text/javascript">
function idOK(){
	opener.document.frm.ID.value = document.frm.OK.value;
	opener.document.frm.idchecked.value = "OK";
	self.close();
}
</script>
</body>
</html>













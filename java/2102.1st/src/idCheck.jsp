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
<h2 align="center">���� �ߺ� Ȯ��</h2>
<form action="idCheck.do" method="get" name="frm">
<input type="hidden" name="OK" value="${ID }"/>
�� �� : <input type="text" name="USER_ID" value="${ID }"/>
<input type="submit" value="�ߺ� �˻�"/><br/>
<c:if test="${ ! empty DUP }">
	<script type="text/javascript">
		opener.document.frm.ID.value = '';
	</script>
${DUP }�� �̹� ��� ���Դϴ�.
</c:if>
<c:if test="${ empty DUP }">
${ID }�� ��� �����մϴ�. 
<input type="button" value="���" onClick="idOK()"/>
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













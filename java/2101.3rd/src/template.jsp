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
<header>
	<h2 align="center"><img alt="" src="imgs/logo.gif"></h2>
</header>
<nav></nav>
<section>
	<table id="body">
		<tr>
			<td width="40%" height="300" class="main">
				<div id="login">
					<c:choose>
						<c:when test="${sessionScope.LOGIN == null }">
							<jsp:include page="login.jsp"/>
						</c:when>
						<c:otherwise>
							<jsp:include page="logout.jsp"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="menu">
					<a href="template.jsp?BODY=intro.jsp">�Ұ���</a><br/>
					<a href="template.jsp?BODY=yogiyo.jsp">������õ</a><br/>
					<a href="template.jsp">������õ</a><br/>
					<a href="template.jsp">�Խñ� ����</a><br/>
					<a href="template.jsp">�Խñ� ���</a><br/>
					<a href="template.jsp">��ǰ ���</a><br/>
					<a href="template.jsp">��ǰ ���</a><br/>
					<a href="template.jsp">��ٱ��� ����</a><br/>
					<a href="template.jsp">�̹��� �� ��� �Խ���</a><br/>
				</div>
			</td>
			<td id="content">
				<jsp:include page="${param.BODY }"/>
			</td>
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">CopyLeft 2021. FromAtoZucchini</h3>
</footer>
</body>
</html>






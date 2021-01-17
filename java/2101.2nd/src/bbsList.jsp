<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>게시글 목록</h2></div>
<%
	String realPath = application.getRealPath("/WEB-INF/bbs");
	File dir = new File(realPath);//지정된 경로로 파일(폴더) 객체를 생성
	String[] filename = dir.list();//해당 폴더에 있는 파일이름을 획득
	if(filename != null){
		for(String name : filename){
				out.print(name);
%>
			<a href="bbsRead.jsp?FILE=<%= name %>"><%= name %></a><br/>
<%			
		}
	}else{
		out.print("등록된 글이 존재하지 않습니다.");
	}
%>
</body>
</html>












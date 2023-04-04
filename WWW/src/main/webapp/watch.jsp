<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.smhrd.model.contentDTO"%>
<%@page import="com.smhrd.model.memberDTO"%>
<%@page import="com.smhrd.model.communityDTO"%>
<%@page import="com.smhrd.model.commentDTO"%>
<%@page import="com.smhrd.model.communityDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="./logo_img/favicon.png">
<meta charset="UTF-8">
<title>W.W.W</title>
<style type="text/css">
	iframe{
		overflow:hidden;
		overflow-x:hidden;
		overflow-y:hidden;
		height:100%;
		width:100%;
		position:absolute;
		top:0px;
		left:0px;
		right:0px;
		bottom:0px
	}
</style>
</head>
<body>
	<%int idx = (int) session.getAttribute("idx");%>
	<%ArrayList<contentDTO> contents = (ArrayList) session.getAttribute("contents");%>
	<%for(int i=0; i<contents.size(); i++){ %>
		<%if(contents.get(i).getV_idx()==idx) {%>
			<%=contents.get(i).getV_iframe()%>
		<%} %>
	<%} %>
	
</body>
</html>
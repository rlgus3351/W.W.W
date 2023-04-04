<%@page import="com.smhrd.controller.contentSearch"%>
<%@page import="com.smhrd.model.contentDTO"%>
<%@page import="com.smhrd.model.memberDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>W.W.W</title>
	<link rel="stylesheet" type="text/css" href="./styles/font_style.css">
<link rel="stylesheet" type="text/css" href="./styles/header_nick.css">
<link rel="icon" href="./logo_img/favicon.png">
	<link rel="stylesheet" href="./styles/main.css">
    <link rel="stylesheet" href="./styles/footer,header.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="./styles/scroll.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="./Js/footer,header_auto_search.js"></script>
    
    
        <!-- 검색창용 -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="./Js/footer,header_auto_search.js"></script>
    
    
    
    
<style>
.none, .list_cont {
	width: 1146px;
	margin : 0 auto;
}

.none:nth-child(n+2){
margin-top: 35px;
}
.list_cont{
margin-top: 35px;
}

span a{
margin-right : 20px;
}
.jh{
color:white;
}

</style>
</head>
<body>

<a href="#top" style="position: fixed;
            right: 55px;
            bottom: 55px;"><img alt="" src="./logo_img/arrow.png"></a>

<!-- 헤더 시작 -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" style="z-index: 9 !important;">
        <div class="container-fluid">
            <a class="navbar-brand" href="contentSearch"><img src="./logo_img/작은 로고.png" alt=""
                    style="width : 80px ; margin-left : 10px"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">               
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" style="font-size : 13pt" aria-current="page"
                            href="contentSearch">홈</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" style="font-size : 13pt" aria-current="page"
                            href="moviePage.jsp">영화</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" style="font-size : 13pt" aria-current="page"
                            href="community.jsp">플레이리스트</a>
                    </li>
                </ul>
				
               <form class="d-flex" role="search" align="center" action ="SearchResult" method="get">
                    <input id="searchInput" style="margin-right: 10px; width: 400px; z-index: 2;"  name = "search" placeholder=" 검색어를 입력해주세요.">
                    <button type="submit" class="btn btn-outline-warning" style = "margin-right : 95px">
                        <p class="btn_link" style="color: white !important; margin : 0;" >검색</p>
                    </button>
                </form>
				<% memberDTO user =(memberDTO)session.getAttribute("user"); %>
				<p class="header_nick"><%=user.getUser_nick()+"님"%></p>
					<form action="logoutService" align="center" method = "post">
                    <button type="button" class="btn btn-outline-warning" style="margin-left : 20px ">
                        <a class="btn_link" style="color: white !important" href="logoutService">로그아웃</a>
                    </button>
                	</form>
				
                


            </div>
        </div>
    </nav>
    <!-- 헤더 끝 -->
    
	<!-- 
		contents안에 담긴 객체(일단 예시)
			v_title : 영화 제목
			v_genre : 영화 장르
			v_year : 방송 년도
			v_synopsis : 시놉시스
			rating : 평점
			v_grade : 연령 등급
			v_iframe : 아이프레임
	-->

	<div id="movie-content-container">
		<div id="movie-title">영화</div>
		<div id="community-title">
			<a href="#">커뮤니티</a>
		</div>
	</div>
	<!-- contentDTO-> Object down casting 필수 -->
	<%
	List<contentDTO> contents = (List) session.getAttribute("contents");
	//String path = "detailContent"
	%>
    <br>   <br>
        <br>
	<!-- 컨텐츠 이미지 박스(가장 큰 틀) -->
	<div style="width : 1146px; margin : 0 auto;">
	<h3 class="jh" style="font-size : 1.75em;">영화</h3>
	</div>
	<div>
		<!-- 이미지 6개씩 한박스에 포장 -->	
		<%for(int i=0; i<(contents.size()/6); i++){%>
			<!-- 먼저 보여줄 리스트 3줄 설정-->
			<% if(i<4) { %>
				<div class="none">
				<!-- 클래스 none에는 애니메이션 효과 x -->
					<span>
					<!-- i는 행단위라고 생각하고 j는 0부터 6전까지 반복 -->	 
					<%for (int j = i*6; j < (i+1)*6; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title()%>">						
						
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
			<% } else{%>
			<!-- 나머지 줄은 숨겨서 애니메이션 효과 작용-->
				<div class="list_cont">
				<!-- div 클래스 list_cont에는 애니메이션 효과 o -->
					<span class="animatable"> 
						<!-- span animatalbe에 css 애니메이션 효과 o -->
						<!-- i는 행단위라고 생각하고 j는 6부터 12전까지 반복 -->	
					<%for (int j = i*6; j < (i+1)*6; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
			<% }%>
		<% }%>
		<!--여긴 임시 데이터 -->
		<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>" />
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg"alt="<%=contents.get(j).getV_title()%>" />
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<% for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
					<div class="list_cont">
					<span class="animatable"> 
					<%for (int j = 6; j < 12; j++) {%> 
						<a href="detailContent?data=<%=contents.get(j).getV_title() %>">
						<img src="./netflix_img/<%=contents.get(j).getV_title()%>.jpg" alt="<%=contents.get(j).getV_title()%>"/>
						</a> 
					<% }%>
					</span>
				</div>
				</div>
	<!-- 컨텐츠 박스 끝 지우면 애니메이션 효과 x -->
	<script type="text/javascript" src="./Js/contentsScoll.js"></script><!-- 스크롤기능 js -->
		
	<script type="text/javascript" src="./Js/main.js"></script>
</body>
</html>
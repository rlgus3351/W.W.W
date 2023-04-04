<!-- ArrayList import  -->
<%@page import="java.util.ArrayList"%>
<!-- contentSearch import-->
<%@page import="com.smhrd.controller.contentSearch"%>
<!-- contentDTO 자료형 import-->
<%@page import="com.smhrd.model.contentDTO"%>
<%@page import="com.smhrd.model.reviewDTO"%>
<%@page import="com.smhrd.model.memberDTO"%>
<!-- jstl import-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/footers/">
<link rel="stylesheet" href="./styles/movie_detail.css">
<link rel="stylesheet" href="./styles/footer,header.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">


<!-- header꺼 -->
<link rel="canonical"
	href="https://getbootstrap.kr/docs/5.2/examples/navbar-fixed/">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- header꺼 -->


<!-- 검색창용 -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./Js/footer,header_auto_search.js"></script>

</head>

<body>
<a href="#top" style="position: fixed;
            right: 55px;
            bottom: 55px;"><img alt="" src="./logo_img/arrow.png"></a>
	<!-- 헤더 시작 -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"
		style="z-index: 9 !important;">
		<div class="container-fluid">
			<a class="navbar-brand" href="contentSearch"><img
				src="./logo_img/작은 로고.png" alt=""
				style="width: 80px; margin-left: 10px"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link active"
						style="font-size: 13pt" aria-current="page" href="contentSearch">홈</a>
					</li>
					<li class="nav-item"><a class="nav-link active"
						style="font-size: 13pt" aria-current="page" href="moviePage.jsp">영화</a>
					</li>
					<li class="nav-item"><a class="nav-link active"
						style="font-size: 13pt" aria-current="page" href="community.jsp">플레이리스트</a>
					</li>
				</ul>

				<form class="d-flex" role="search" align="center"
					action="SearchResult" method="get">
					<input id="searchInput"
						style="margin-right: 10px; width: 400px; z-index: 2;"
						name="search" placeholder=" 검색어를 입력해주세요.">
					<button type="submit" class="btn btn-outline-warning"
						style="margin-right: 95px">
						<p class="btn_link" style="color: white !important; margin: 0;">검색</p>
					</button>
				</form>
				<%
				memberDTO user = (memberDTO) session.getAttribute("user");
				%>
				<p class="header_nick"><%=user.getUser_nick() + "님"%></p>
				<form action="logoutService" align="center" method="post">
					<button type="button" class="btn btn-outline-warning"
						style="margin-left: 20px">
						<a class="btn_link" style="color: white !important"
							href="logoutService">로그아웃</a>
					</button>
				</form>




			</div>
		</div>
	</nav>
	<!-- 헤더 끝 -->



	<%
	// session에서 꺼내올 때 강제 형변환 해주기
	String data = (String) session.getAttribute("title");
	int idx = (int) session.getAttribute("idx");

	// 세션에 담긴 컨텐츠 항목 불러오기
	ArrayList<contentDTO> contents = (ArrayList) session.getAttribute("contents");
	ArrayList<reviewDTO> reviews = (ArrayList) session.getAttribute("review");
	ArrayList<memberDTO> user_list = (ArrayList) session.getAttribute("user_list");
	%>






	<!-- main -->


	<div class="wrapper">

		<main>


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

			<%
			for (int i = 0; i < contents.size(); i++) {
			%>
			<!-- 컨텐츠 크기만큼 반복해서 입력받은 data와 같은지 비교하기-->
			<%
			if (contents.get(i).getV_title().equals(data)) {
			%>

			<div class=contents_wrap>

				<!-- 왼쪽-->
				<div id="a">
					<section class="poster_img">

						<img src="./thumbnail_img/<%=contents.get(i).getV_title()%>.jpg"
							width="300px" height="426px">
						<hr style="color: white;">
						<table class="information">

							<tr>
								<td>평점</td>
								<td><%=contents.get(i).getV_rating()%></td>
							</tr>
							<tr>
								<td>장르</td>
								<td><%=contents.get(i).getV_genre()%></td>
							</tr>
							<tr>
								<td>연령</td>
								<td>
									<%
									if (contents.get(i).getV_grade() == 12) {
									%> <img alt="" src="./logo_img/12.png"> <%
 } else if (contents.get(i).getV_grade() == 19) {
 %> <img alt="" src="./logo_img/19.png"> <%
 } else {
 %> <img alt="" src="./logo_img/15.png"> <%
 }
 %>
								</td>
							</tr>




						</table>
					</section>


				</div>
				<div id="b">

					<!-- 오른쪽  -->
					
					<div>
					
					<div style="float: left">
						<h2><%=contents.get(i).getV_title()%>
						</h2>
					</div>
					<div>
						<button type="button" class="btn btn-outline-warning">
							<a class="btn_link" style="color: white !important;" href="watch.jsp">
								<img src="./logo_img/재생_1.png" width=30px; height=30px;>
								&nbsp지금시청하기
							</a>
						</button>
					</div>
					</div>
					
					
					<h4 style="color: gray;">
						&nbsp(<%=contents.get(i).getV_year()%>)
					</h4>
					
					
					
					


					<div style="float: left; margin-right: 495px;">
					<br>
						<h4>예고편</h4>
					</div>
					
					<%=contents.get(i).getV_iframe()%>

					<br> <br>
					<hr style="color: white;">

					<h4>시놉시스</h4>
					<br>
					<p><%=contents.get(i).getV_synopsis()%></p>


					<%
					}
					%>
					<%
					}
					%>
					<hr style="color: white;">


					<h3>리뷰</h3>
						<div style="margin-right: 20px;">
							<form action="reviewText" method="post">
								<textarea class="form-control" cols="100" rows="5"
									name="review_content" style="resize: none;"></textarea>
								<input id="review" type="submit" value="등록">
							</form>



							<%
							boolean isReview = false;
							%>


					<div class="scroll_contatiner"
						style="overflow-y: scroll; width: 767px; height: 750px;">
							<div class="none">
								<%
								for (int i = 0; i < reviews.size(); i++) {
								%>
								<%
								if (reviews.get(i).getV_idx() == idx) {
								%>
								<%
								isReview = true;
								%>
								<span>
									<div class="d-flex mb-4">
										<div class="flex-shrink-0">
											<img class="rounded-circle"
												src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
												alt="...">
										</div>
										<div class="ms-3">
											<%
											for (int j = 0; j < user_list.size(); j++) {
											%>
											<%
											if (reviews.get(i).getUser_id().equals(user_list.get(j).getUser_id())) {
											%>
											<%
											if (reviews.get(i).getUser_id().equals("admin")) {
											%>
											<div class="fw-bold">크롤링 데이터</div>
											<%
											} else {
											%>
											<div class="fw-bold"><%=user_list.get(j).getUser_nick()%></div>
											<%
											}
											%>
											<%
											}
											%>
											<%
											}
											%>

											<%=reviews.get(i).getReview_content()%>
											(<%=reviews.get(i).getReview_dt()%>)
											<%
											if (reviews.get(i).getUser_id().equals(user.getUser_id())) {
											%>
											<a
												href="deleteReview?data=<%=reviews.get(i).getReview_idx()%>"
												style="font-size: 17px; text-decoration: none;">❌</a>
											<%
											}
											%>

										</div>
										<hr>
									</div>
								</span>
								<%
								}
								%>

								<%
								}
								%>
							</div>



							<%
							if (isReview != true) {
							%>
							<br>
							<h3>등록된 리뷰가 없습니다.</h3>
							<%
							}
							%>
						</div>


						<br> <br>

					</div>
				</div>
			</div>


		</main>
	</div>












	<!-- 발바닥 -->
	<div class="container">
		<footer>
			<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                <symbol id="bootstrap" viewBox="0 0 118 94">
                    <title>Bootstrap</title>
                    <path fill-rule="evenodd" clip-rule="evenodd"
					d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z">
                    </path>
                </symbol>
                <symbol id="facebook" viewBox="0 0 16 16">
                    <path
					d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z" />
                </symbol>
                <symbol id="instagram" viewBox="0 0 16 16">
                    <path
					d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z" />
                </symbol>
                <symbol id="twitter" viewBox="0 0 16 16">
                    <path
					d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z" />
                </symbol>
            </svg>
		</footer>





		<footer
			class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<div class="col-md-4 d-flex align-items-center">
				<a href="/"
					class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
					<svg class="bi" width="30" height="24">
                        <use xlink:href="#bootstrap" />
                    </svg>
				</a> <span class="mb-3 mb-md-0 text-muted">&copy; 스마트인재개발원</span>
			</div>

			<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
                            <use xlink:href="#twitter" />
                        </svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
                            <use xlink:href="#instagram" />
                        </svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg
							class="bi" width="24" height="24">
                            <use xlink:href="#facebook" />
                        </svg></a></li>
			</ul>
		</footer>
		<!-- 발바닥 끝 -->

	</div>





</body>
</html>
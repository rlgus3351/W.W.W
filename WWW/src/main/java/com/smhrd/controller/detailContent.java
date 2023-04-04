package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.contentDTO;
import com.smhrd.model.reviewDTO;


@WebServlet("/detailContent")
public class detailContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//----------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기 ----------------------------------------------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		// 영화를 클릭하면 데이터에 영화 제목이 data = "영화 제목"으로 오기때문에 data의 값을 불러준다.
		// moviePage의 a태그 속성 <a href="detailContent?data=<%=contents.get(j).getV_title()%>">
		//----------------------------------------------------------------------- 1. 데이터 가져오기 ------------------------------------------------------------------------------------------------------------------//
		String data = request.getParameter("data");
		
		session.setAttribute("title", data);
		//----------------------------------------------------------------------- 2. 세션에 저장된 contents 내용 가져오기!------------------------------------------------------------------------------------------------//
		ArrayList<contentDTO> contents = (ArrayList)session.getAttribute("contents");
		
		
		//----------------------------------------------------------------------- 3. 제목을 갖는 인덱스 값 추출하기-------------------------------------------------------------------------------------------------------//
		// idx라는 변수를 선언해서 전체 컨텐츠 리스트 중에 해당 제목을 갖는 인덱스 값 추출하기
		int idx=0;
		for(int i=0; i<contents.size(); i++) {
			// contents ArrayList에서 데이터와 같은 이름을 갖는 값이 있으면 idx로 영화 컨텐츠 인덱스 값 추출하기
			if(contents.get(i).getV_title().equals(data)) {
				idx =contents.get(i).getV_idx();
				// 세션에 저장하기!
				session.setAttribute("idx", idx);
			}
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("영화 인덱스 번호 : "+idx);
		System.out.println("데이터 내용 : "+data);
		System.out.println("---------------------------------------------------------------------");
		
		//----------------------------------------------------------------------- 4. 페이지 이동하기-------------------------------------------------------------------------------------------------------//
		// 넣은 결과창을 보여줘야 하니까 jsp파일로 이동
		response.sendRedirect("movie_detail.jsp");
	}

}

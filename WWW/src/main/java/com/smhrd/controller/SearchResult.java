package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//-------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기----------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//-------------------------------------------------------------------- 1. 데이터 가져오기-------------------------------------------------------------------------------//
		// 검색 결과 값이 search 파라미터로 전달된다.
		String search = request.getParameter("search");
		
		// 세션에 값에 search_result의 이름으로 검색받은 결과값 넣어주기
		session.setAttribute("search_result", search);
		
		// 다시 결과창에 보여줘야하므로 search_result.jsp로 이동
		// search_result.jsp에서 넘겨 받은 search 값으로 제어한다.
		response.sendRedirect("search_result.jsp");
		
	}

}

package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.memberDTO;
import com.smhrd.model.reviewDAO;
import com.smhrd.model.reviewDTO;


@WebServlet("/reviewText")
public class reviewText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//-------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기----------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//-------------------------------------------------------------------- 1. 데이터 가져오기-------------------------------------------------------------------------------//
		String review_content = request.getParameter("review_content");
				
		// 1-1. 영화 인덱스 불러오기
		int idx = (int)session.getAttribute("idx");
		// 1-2. 유저객체 불러오기 불러오기
		memberDTO user= (memberDTO) session.getAttribute("user");
		
		// 1-3. reviewDTO 생성
		reviewDTO dto = new reviewDTO();
		
		// 1-4. 작성 날짜 => 23-04-01로 포맷팅 
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
		
		//-------------------------------------------------------------------- 2. reviewDTO에 데이터 넣어주기!-----------------------------------------------------------------//
		dto.setV_idx(idx);
		dto.setReview_content(review_content);
		dto.setReview_dt(df.format(date));
		dto.setUser_id(user.getUser_id()); 
		
		//-------------------------------------------------------------------- 3. review 테이블에 데이터 넣기-------------------------------------------------------------------//
		// 3-1. reviewDAO 객체 생성
		reviewDAO dao = new reviewDAO();
		
		// 3-2. reviewDAO에 write 메소드 실행하기!
		int cnt = dao.write(dto);

		// 3-3. 결과 확인하기!
		if (cnt >0) {
			System.out.println("저장 성공");
		}else{
			System.out.println("저장 실패");
		}
		
		//-------------------------------------------------------------------- 4. 갱신하기------------------------------------------------------------------------------------//
		// 4-1. reviewDAO의 search 메소드 사용하여 전체 리뷰 데이터 출력하기
		ArrayList<reviewDTO> review_list = dao.search();
		if (review_list != null) {
			//dao의 search 메소드를 사용하여 결과 값이 반환된 경우
			
			session.setAttribute("review", review_list);
			// 반복해서 세션에 데이터를 넘긴 후에 movie_detail.jsp로 이동한다.
		}
		response.sendRedirect("movie_detail.jsp");
		
		
	}

}

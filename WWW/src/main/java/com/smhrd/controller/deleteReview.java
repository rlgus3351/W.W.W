package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.reviewDAO;
import com.smhrd.model.reviewDTO;


@WebServlet("/deleteReview")
public class deleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기 ----------------------------------------------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//-----------------------------------------------------------------------1. 데이터 꺼내오기 --------------------------------------------------------------------------------------------------------------------//
		// 해당 서블릿으로 오기 전에 movie.jsp의  
		// a태그 속성으로<a href="deleteReview?data=<%=reviews.get(i).getReview_idx()%>" data값으로 리뷰의 글 번호가 넘어온다.
		String temp = request.getParameter("data");
		// 넘어온 데이터는 String이고, 우리가 테이블에 저장할 부분 리뷰의 글 번호(Number) 타입 이므로 형변환을 해줘야한다.
		int idx = Integer.parseInt(temp);
		
		// 1-1. 인덱스 번호 확인하기.
		System.out.println("삭제할 글 번호 : "+ idx);
		
		//----------------------------------------------------------------------- 2. review DTO, DAO 불러오기 | DAO에 보낼 DTO 값 넣어서 셋팅 하기!  -----------------------------------------------------------------------//
		reviewDTO dto = new reviewDTO();
		dto.setReview_idx(idx);
		reviewDAO dao = new reviewDAO();
		
		//----------------------------------------------------------------------- 3. reviewDAO의 delete 메소드를 사용해서 삭제해주기 ---------------------------------------------------------------------------------------//
		int row = dao.delete(dto);
		
		// 3-2. 반환 결과 확인하기
		if(row>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		//----------------------------------------------------------------------- 4. 리뷰 데이터 갱신하기 ----------------------------------------------------------------------------------------------------------------//
		// 리뷰 데이터도 세션에 review라는 이름으로 저장되어 있는데, 삭제 되기 전에 데이터이므로, 삭제 후 갱신하여 다시 세션에 저장시켜줘야 한다!
		ArrayList<reviewDTO> review_list = dao.search();
		if (review_list != null) {
			//dao의 search 메소드를 사용하여 결과 값이 반환된 경우
			
			// 세션에 review라는 이름으로 저장하기!(이름이 같아도 저장하면 추후에 저장한 데이터가 세션에 남는다.!)
			session.setAttribute("review", review_list);
			// 반복해서 세션에 데이터를 넘긴 후에 main.jsp로 이동한다.
		}
		//----------------------------------------------------------------------- 5. movie_detail.jsp로 이동 ---------------------------------------------------------------------------------------------------------//
		response.sendRedirect("movie_detail.jsp");
		
		
	}

}

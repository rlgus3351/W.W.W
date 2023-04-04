package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.communityDAO;
import com.smhrd.model.communityDTO;


@WebServlet("/deleteCommunity")
public class deleteCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//---------------------------------------------------------------------- 0. 한글 인코딩, 세션 가져오기--------------------------------------------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//---------------------------------------------------------------------- 1. 데이터 가져오기------------------------------------------------------------------------------------------------------------------//
		// 이전 페이지 community.jsp 에서 넘어오는 데이터는 a태그의 아래와 같은 형태로 data이름으로 커뮤니티 글 인덱스 번호가 넘어온다.
		//<a href="deleteCommunity?data=<%=c_list.get(i).getC_idx()%>" style="text-decoration:none;">❌</a>
		
		// String -> int 형변환
		int idx = Integer.parseInt(request.getParameter("data"));
		// 데이터 확인
		System.out.println("삭제 할 글 번호" + idx);
		
		//---------------------------------------------------------------------- 2. DTO, DAO 불러와서 데이터 넣어주기--------------------------------------------------------------------------------------------------//
		
		// DTO, DAO 객체 불러오기
		communityDTO dto = new communityDTO();
		communityDAO dao = new communityDAO();
		
		// DTO에 삭제할 커뮤니티 글 인덱스 번호 넣어주기
		dto.setC_idx(idx);
		
		//---------------------------------------------------------------------- 3. DAO에 삭제 기능 메소드 사용하기 --------------------------------------------------------------------------------------------------//
		
		// DAO의 deleteComm 메소드를 사용하여 글 번호를 넘겨준다.
		int row = dao.deleteComm(dto);
		if(row>0) {
			System.out.println("커뮤니티 게시글 삭제 완료");
		}else {
			System.out.println("커뮤니티 게시글 삭제 실패");
		}
		
		//---------------------------------------------------------------------- 4. 커뮤니티 글 갱신하기 -------------------------------------------------------------------------------------------------------------//
		
		// DAO의 selectAll메소드를 사용하여 갱신해주기
		ArrayList<communityDTO> comm_list = dao.selectAll();
		
		if (comm_list != null) {
			
			session.setAttribute("community", comm_list);
			// 반복해서 세션에 데이터 저장
		}
		// community.jsp로 이동.
		response.sendRedirect("community.jsp");
			
	}

}

package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.boardDAO;
import com.smhrd.model.boardDTO;
import com.smhrd.model.commentDAO;
import com.smhrd.model.commentDTO;
import com.smhrd.model.memberDTO;


@WebServlet("/detailPlayList")
public class detailPlayList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//----------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기 ----------------------------------------------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//----------------------------------------------------------------------- 1. 데이터 가져오기 -------------------------------------------------------------------------------------------------------------------//		
		// 이전 페이지 community.jsp a태그 속성 <a href="detailPlayList?data=<%=c_list.get(i).getC_idx()%>">
		String data = request.getParameter("data");
		System.out.println("플레이 리스트 번호 : "+ data);
		
		//----------------------------------------------------------------------- 2. 좋아요 기능을 하는 boardDAO, DTO 불러오기 -------------------------------------------------------------------------------------------//		
		// boardDTO 정보
		// 커뮤니티 글 정보 : no_number;
		// 회원 아이디 : user_id
		boardDAO dao = new boardDAO();
		boardDTO dto = new boardDTO();
		
		//----------------------------------------------------------------------- 3. boardDTO에 넣어줄 회원 정보 세션에서 가져오기------------------------------------------------------------------------------------------//
		
		memberDTO user = (memberDTO)session.getAttribute("user");
		// 3-1. boardDTO에 데이터 넣기! (getter메소드로 id 추출, data 형변환(String-> int)
		dto.setUser_id(user.getUser_id());
		dto.setNo_number(Integer.parseInt(data));
		
		//-----------------------------------------------------------------------  4. boardDAO테이블 조회하기 ----------------------------------------------------------------------------------------------------------//
		// 4. boardDAO checkLike 메소드의 결과 값을 row에 저장
		// 로그인 된 아이디로 어떠한 플레이리스트 글에 좋아요를 눌렀는지 안눌렀는지 판단하는 메소드!
		int row =dao.checkLike(dto);
		
		//----------------------------------------------------------------------- 5. commentDAO를 객체를 불러 댓글 조회 하기! ---------------------------------------------------------------------------------------------//

		commentDAO cm_dao = new commentDAO();
		ArrayList<commentDTO> cm_list = (ArrayList) cm_dao.selectAll();
		//----------------------------------------------------------------------- 6. 세션에 저장하기 -------- ----------------------------------------------------------------------------------------------------------//
		
		session.setAttribute("comment", cm_list);
		session.setAttribute("playIdx", data);
		session.setAttribute("likeCheck", row);
		response.sendRedirect("community_1.jsp");
		}

}

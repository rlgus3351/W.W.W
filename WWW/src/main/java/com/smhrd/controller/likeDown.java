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

import com.smhrd.model.boardDAO;
import com.smhrd.model.boardDTO;
import com.smhrd.model.communityDAO;
import com.smhrd.model.communityDTO;
import com.smhrd.model.memberDTO;


@WebServlet("/likeDown")
public class likeDown extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기----------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//-------------------------------------------------------------------- 1. 데이터 가져오기-------------------------------------------------------------------------------//
		// 이전 페이지 community_1.jsp의 a태그 <a href="likeDown?data=<%=c_list.get(idx).getC_idx()%>">
		// String타입 형변환
		// row는 커뮤니티 글의 인덱스 번호!
		int row = Integer.parseInt(request.getParameter("data"));
		//-------------------------------------------------------------------- 2. boardDTO에 넣은 데이터 가져오기!----------------------------------------------------------------//		
		// 2-1. 세션에 저장된 user(로그인 된 정보!)
		memberDTO user = (memberDTO)session.getAttribute("user");
		
		// 2-2 boardDTO에 (커뮤니티 글 번호, 로그인된 유저 정보!)
		boardDTO dto = new boardDTO(row, user.getUser_id());
		
		//-------------------------------------------------------------------- 3. board 테이블에 해당하는 데이터 삭제하기------------------------------------------------------------//
		// 3-1. boardDAO 객체 생성하기
		boardDAO dao = new boardDAO();
		// 3-2. boardDAO의 likeDown 메소드 사용하여 반환 값 result에 저장
		int result = dao.likeDown(dto);
		// 3-3. 반환 결과 확인하기!
		if(result>0) {
			System.out.println("BOARD 테이블 저장 성공");			
		}else {
			System.out.println("BOARD 테이블 저장 실패");
		}
		//-------------------------------------------------------------------- 4. community 테이블에 좋아요 숫자 업데이트 해주기!----------------------------------------------------//		
		
		// 4-1. communityDTO, dao 객체 생성
		communityDTO c_dto = new communityDTO();
		communityDAO c_dao = new communityDAO();
		
		// 4-2. c_dto에 행 번호 넣어주기!
		c_dto.setC_idx(row);
		
		// 4-3. communityDAO의 Donwlike 메소드 적용하기
		int likeResult = c_dao.Downlike(c_dto);
		
		// 4-4. 반환 결과 확인하기!
		if(likeResult>0) {
			System.out.println("COMMUNITY 테이블 저장 성공");			
		}else {
			System.out.println("COMMUNITY 테이블 저장 실패");
		}
		//-------------------------------------------------------------------- 5. 갱신하기----------------------------------------------------//
		// 5번을 하는 이유는 community_1.jsp에서 checkLike의 값이 0,1로 로그인 한 회원이 좋아요를 눌렀는지 
		// 안눌렀는지 판단하기 때문에 새로 갱신을 해줘야한다.
		
		// 5-1. boardDAO의 checkLike 메소드 실행
		int row2 = dao.checkLike(dto);
		// 5-2. detailPlayList 서블릿에서 세션에 저장한 키 값을 동일하게 하여 넣어준다!
		session.setAttribute("likeCheck", row2);
		
		// 5-3. 커뮤니티 게시글도 좋아요 숫자가 업데이트 되므로 갱신해줘야한다!
		ArrayList<communityDTO> comm_list = c_dao.selectAll();
		if (comm_list != null) {
			//dao의 search 메소드를 사용하여 결과 값이 반환된 경우
			// 세션에 contents라는 이름으로 불러온 리스트 들고오기
			session.setAttribute("community", comm_list);
			// 반복해서 세션에 데이터를 넘긴 후에 main.jsp로 이동한다.
		}
		// 5-4. community_1.jsp로 이동하기
		response.sendRedirect("community_1.jsp");
	}

}

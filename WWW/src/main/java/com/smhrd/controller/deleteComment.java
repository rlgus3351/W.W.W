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

import com.smhrd.model.commentDAO;
import com.smhrd.model.commentDTO;

@WebServlet("/deleteComment")
public class deleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//---------------------------------------------------------------------- 0. 한글 인코딩, 세션 가져오기--------------------------------------------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//----------------------------------------------------------------------  1. 데이터 꺼내오기----------------------------------------------------------------------------------------------------------------//
		// 해당 서블릿으로 오기 전에 community_1.jsp의  
		//a태그 속성으로 <a href="detailContent?data=<%=content[j]%>"> data값으로 넘어온다.
		
		// data 속성은 String 타입으로 Integer.parseInt로 int형으로 형변환을 하면 해당 플레이리스트의 글 번호가 나온다!
		int idx = Integer.parseInt(request.getParameter("data"));
		
		//System.out.println("삭제할 글 번호 : " + idx); 데이터 확인 작업

		//----------------------------------------------------------------------  2. DTO, DAO 객체 불러오고, DAO로 보낼 DTO 데이터 넣어주기------------------------------------------------------------------------------//
		
		// commentDTO 객체 생성
		commentDTO dto = new commentDTO();
		// commentDAO 객체 불러주기
		commentDAO dao = new commentDAO();
		
		// 댓글 번호 : cmt_idx
		// 원글(커뮤니티 글 번호) : c_idx
		// 댓글 내용 : cmt_content
		// 작성 일자 : cmt_dt
		// 작성자 : user_id
		
		// 삭제할 글 번호를 dto에 cmt_idx로 값을 넣어주기
		dto.setCmt_idx(idx);
		//----------------------------------------------------------------------  3. DAO의 deleteComment 메소드에 매개변수 dto 넘겨주기-------------------------------------------------------------------------------//
		// 3-1. DAO의 deleteComment 메소드에 매개변수 dto 넘겨주기
		int row = dao.deleteComment(dto);
		
		// 3-2. 반환 결과 출력해서 확인하기.
		if (row > 0) {
			System.out.println("댓글 삭제 성공");
		} else {
			System.out.println("댓글 삭제 실패");
		}
		
		//-----------------------------------------------------------------------  4. 댓글 정보 갱신하기 ----------------------------------------------------------------------------------------------------------//
		//댓글이 삭제 되었으면, 세션에 남아있는 댓글 정보들은 삭제가 되기 이전의 값들로 저장되어 있으므로 갱신 해줘야 페이지에 반영이 된다!!!!!!
		
		// commentDAO에 selectAll 메소드를 사용하여 전체 댓글을 조회한다.
		ArrayList<commentDTO> cm_list = (ArrayList) dao.selectAll();
		
		//-----------------------------------------------------------------------  5. 반환 결과 출력해서 확인하기-----------------------------------------------------------------------------------------------------//
		if (cm_list != null) {
			System.out.println("댓글 조회 성공");
		} else {
			System.out.println("댓글 조회 실패");
		}
		//-----------------------------------------------------------------------  6. 세션에 comment이름에 저장해주기!-------------------------------------------------------------------------------------------------//
		session.setAttribute("comment", cm_list);
		
		//----------------------------------------------------------------------- 7. 페이지를 재 요청해야하므로 sendRedirect 방식으로 community_1.jsp로 이동시켜준다.--------------------------------------------------------//
		response.sendRedirect("community_1.jsp");

	}

}

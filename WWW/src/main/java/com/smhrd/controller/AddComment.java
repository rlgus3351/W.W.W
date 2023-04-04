package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.commentDAO;
import com.smhrd.model.commentDTO;
import com.smhrd.model.memberDTO;


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//------------------------------------------------------DB에 추가할 데이터 불러오기--------------------------------------------------//
		// 1. 한글 인코딩, 필요한 도구 꺼내기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();
		HttpSession session = request.getSession();
		
		// 2. 데이터 변수에 저장하기 (댓글 작성 내용이 넘어온다.)
		String content = request.getParameter("content");
		
		// 3. commentDTO에 넣을 데이터 처리해주기
		
		// 3-1. 작성자 정보 빼오기
		memberDTO user = (memberDTO) session.getAttribute("user");
		
		// 3-2. 작성일자 포멧팅 이용해서 작성일자 수정하기
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
		String day = df.format(date);
		
		// 3-3 작성할 글 번호 불러오기 -> playIdx로 세션에 저장해놓음.(String 타입이므로 int형으로 형변환 해줘야한다.)
		String data = (String) session.getAttribute("playIdx");
		int idx = Integer.parseInt(data);
//------------------------------------------------------데이터 불러온 데이터 확인 작업--------------------------------------------------//
		System.out.println("---------------------------------------------------------------");
		System.out.println(user);
		System.out.println("작성자 :" + user.getUser_nick());
		System.out.println("작성 일자 :" + day);
		System.out.println("작성 글 번호 : "+ idx);
		System.out.println("작성 내용 : " + content);
		System.out.println("---------------------------------------------------------------");
		
//------------------------------------------------------데이터 DB연결시키기--------------------------------------------------//
		
		// 4. commentDTO에 처리한 데이터 넣어주기
		commentDTO dto = new commentDTO();
		dto.setC_idx(idx);
		dto.setCmt_content(content);
		dto.setCmt_dt(day);
		dto.setUser_id(user.getUser_id());
		
		// 5. commentDAO를 불러 댓글 등록 기능 수행하기
		commentDAO dao = new commentDAO();
		int row = dao.addComment(dto);
		
		// 6. 반환 값에 따라 결과 처리해주기
		if(row>0) {
			// 6-1. 반환 값이 1이면 댓글 저장이 성공
			System.out.println("댓글 저장 성공");
			
		}else {
			// 6-2. 반환 값이 0이면 댓글 저장이 실패
			System.out.println("댓글 저장 실패");
		}
		// 7. 댓글 내용이 삽입되면 다시 갱신을 해줘야 하기 때문에 댓글을 전체 조회하여 다시 세션에 comment 값으로 넣어주기
		ArrayList<commentDTO> cm_list = (ArrayList) dao.selectAll();
		session.setAttribute("comment", cm_list);
		// 8. community_1.jsp로 이동
		response.sendRedirect("community_1.jsp");
		
	}

}

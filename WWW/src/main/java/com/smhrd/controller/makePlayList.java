package com.smhrd.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.communityDAO;
import com.smhrd.model.communityDTO;
import com.smhrd.model.memberDTO;


@WebServlet("/makePlayList")
public class makePlayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//-------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기----------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//-------------------------------------------------------------------- 1. 데이터 가져오기-------------------------------------------------------------------------------//
		// 비동기 통신 (data 부분을 보면 genre와 movies로 넘어온다!)
		//$.ajax({
	    //       url:"http://localhost:8081/WWW/makePlayList",
	    //       type:"POST",
	    //       data:{genre:checks, movies:selectMoives},
	    //       success:function(){
	    //           location.href="makePlayList"
	    //           console.log("성공");
	    //       }
		
		// 1-1. 데이터 가져오기
		String genre = request.getParameter("genre");
		String movies = request.getParameter("movies");
		
		// 1-2. 데이터 확인
		System.out.println(genre);
		System.out.println(movies);
		
		//-------------------------------------------------------------------- 2. communityDTO에 데이터 넣어주기!------------------------------------------------------------//		
		
		// 2-1. communityDTO 객체 생성
		communityDTO dto = new communityDTO();
		// communityDTO 정보 
		// 커뮤니티 글 인덱스 : c_idx;
	    // 글 내용 c_content 
		// 글 작성일자 c_date
	    // 글 좋아요수 c_likes
	    // 글 해시태그 c_hashtag
	    // 글 작성자 user_id
		
		
		// 2-2. 날짜 설정하기 
		//ex) 23-04-01로 해야 데이터가 들어간다.
		Date date = new Date();
		// date 객체는 형변환 없이도 바로 출력이 가능하다.
		System.out.println(date.toString());	
		// SimpleDateFormat 이용해 출력형식 지정
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
		// System.out.println(df.format(date)); // format은 String 객체 반환, 
		memberDTO user = (memberDTO)session.getAttribute("user");
		
		// 2-3. dto에 값 넣어주기!
		dto.setC_content(movies);
		dto.setC_date(df.format(date));
		dto.setC_hashtag(genre);
		dto.setC_likes(0);	
		dto.setUser_id(user.getUser_id());
		
		// 2-4. 내용 확인!
		System.out.println("내용 : "+dto.getC_content());
		System.out.println("날짜 : "+dto.getC_date());
		System.out.println("해쉬태그 : "+dto.getC_hashtag());
		System.out.println("좋아요 : "+dto.getC_likes());
		System.out.println("작성자 : "+dto.getUser_id());
		
		//-------------------------------------------------------------------- 3. community 테이블에 데이터 넣기------------------------------------------------------------------------//
		
		// 3-1. communityDAO 객체 생성하기
		communityDAO dao = new communityDAO();
		
		// 3-2. dto에 담긴 내용이 null이 아닐 때 실행!
		if(dto.getC_content() !=null) {
			// 3-3 communityDAO의 sendCommunity 메소드 실행하기.
			int row = dao.sendCommunity(dto);
			
			// 3-4 결과 값에 따라 출력문으로 확인하기!
			if(row>0) {
				System.out.println("DB 저장 성공");
			}else {
				System.out.println("DB 저장 실패");
			}
		}
		
		//-------------------------------------------------------------------- 4. 갱신하기--------------------------------------------------------------------------------------------//
		
		// 4-1. communityDAO의 selectAll 메소드 사용하기!
		ArrayList<communityDTO> comm_list = dao.selectAll();
		if (comm_list != null) {
		
			session.setAttribute("community", comm_list);
			// 반복해서 세션에 데이터를 넘긴 후에 main.jsp로 이동한다.
		}
		response.sendRedirect("community.jsp");
		
		
	}

}

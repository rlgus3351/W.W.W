package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.memberDAO;
import com.smhrd.model.memberDTO;

@WebServlet("/signupService")
public class signupService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//-------------------------------------------------------------------- 0. 한글 인코딩, 세션 불러오기----------------------------------------------------------------------//
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		//-------------------------------------------------------------------- 1. 데이터 가져오기-------------------------------------------------------------------------------//
		
		// 1-1. form태그의 name값으로 데이터를 저장한다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		String user_gender = request.getParameter("user_gender");
		String user_birthdate[] = request.getParameterValues("user_birthdate");
		
		// 1-2. 가입날짜를 설정하기 위한 date 객체 생성
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
		System.out.println(df.format(date)); // format은 String 객체 반환,
		String birthdate = user_birthdate[0].substring(2) + "-" + user_birthdate[1] + "-" + user_birthdate[2];
		
		// 1-3. 데이터 확인.
		System.out.println(date.toString());
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(user_nick);
		System.out.println(user_gender);
		System.out.println(birthdate);

		//-------------------------------------------------------------------- 2. memberDTO에 데이터 넣어주기!------------------------------------------------------------//
		// memberDTO 필드명
		// 아이디 : user_id
		// 비밀번호 : user_pw
		// 닉네임 : user_nick
		// 성별 : user_gender
		// 생년월일 : user_birthdate
		// 가입 날짜 : user_joindate
		// 유저 형식 : user_type
		
		// 2-1. memberDTO 객체 생성
		memberDTO dto = new memberDTO();
		
		// 2-2. DTO에 값 넣어주기 
		dto.setUser_id(user_id);
		dto.setUser_pw(user_pw);
		dto.setUser_nick(user_nick);
		dto.setUser_gender(user_gender);
		dto.setUser_birthdate(birthdate);
		dto.setUser_joindate(df.format(date));
		dto.setUser_type('U');
		
		//-------------------------------------------------------------------- 3. user 테이블에 데이터 넣기------------------------------------------------------------//
		
		// 3-1. memberDAO 객체 생성
		memberDAO dao = new memberDAO();
		
		// 3-2. memberDAO의 singup 메소드 사용
		int cnt = dao.signup(dto);
		
		System.out.println("cnt : " + cnt);
		// 3-3. 결과 출력, alert창 출력
		if (cnt > 0) {

			System.out.println("성공");
			out.println("<script>alert('회원가입이 완료되었습니다. 로그인 해주세요!'); location.href='login.html';</script>");
			// response.sendRedirect("login.html");
			out.close();
		} else {
			out.println("<script>alert('중복된 아이디 및 닉네임이 있어요.! 다시 진행해 주세요.'); location.href='signup.html';</script>");
			// response.sendRedirect("login.html");
			out.close();
			System.out.println("실패");
//			response.sendRedirect("signup.html");
		}

	}

}

package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logoutService")
public class logoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 세션, printWriter 불러오기, 한글 인코딩
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {			
			// session 안에 들어있는 user정보 삭제
			session.removeAttribute("user");
			
//			response.sendRedirect("first_window.html");
//			
			System.out.println("로그아웃 성공");
			
			out.println("<script>alert('로그아웃에 정상적으로 성공하였습니다.'); location.href='first_window.html';</script>"); 
			//response.sendRedirect("login.html");
			out.close();
			
		} catch (Exception e) {
			
			System.out.println("로그아웃 실패");
		}
		
		
	}

}

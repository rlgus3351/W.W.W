package com.smhrd.model;

public class boardDTO {

	// 커뮤니티 글 정보
	private int no_number;
	// 회원 아이디
	private String user_id;
	
	// 기본 생성자
	public boardDTO() {

	}
	
	// 생성자
	public boardDTO(int no_number, String user_id) {
		super();
		this.no_number = no_number;
		this.user_id = user_id;
	}
	
	// getter/ setter 메소드
	public int getNo_number() {
		return no_number;
	}

	public void setNo_number(int no_number) {
		this.no_number = no_number;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}

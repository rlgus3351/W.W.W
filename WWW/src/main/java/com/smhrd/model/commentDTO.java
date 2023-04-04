package com.smhrd.model;

public class commentDTO {
	// 댓글 번호
	private int cmt_idx;
	// 원글(커뮤니티 글 번호)
	private int c_idx;
	// 댓글 내용
	private String cmt_content;
	// 작성 일자
	private String cmt_dt;
	// 작성자
	private String user_id;

	// 기본 생성자
	public commentDTO() {

	}
	// 생성자
	public commentDTO(int cmt_idx, int c_idx, String cmt_content, String cmt_dt, String user_id) {
		super();
		this.cmt_idx = cmt_idx;
		this.c_idx = c_idx;
		this.cmt_content = cmt_content;
		this.cmt_dt = cmt_dt;
		this.user_id = user_id;
	}
	// getter/setter 메소드
	public int getCmt_idx() {
		return cmt_idx;
	}

	public void setCmt_idx(int cmt_idx) {
		this.cmt_idx = cmt_idx;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public String getCmt_dt() {
		return cmt_dt;
	}

	public void setCmt_dt(String cmt_dt) {
		this.cmt_dt = cmt_dt;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}

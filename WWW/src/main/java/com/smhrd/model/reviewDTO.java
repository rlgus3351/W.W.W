package com.smhrd.model;

public class reviewDTO {
	//리뷰 글 번호
	private	int review_idx;
	//컨텐츠 번호
	private int v_idx; 
	//리뷰 내용
	private String review_content;
	// 작성 날짜
	private String review_dt;
	// 작성자
	private String user_id; 
	
	// 기본 생성자
	public reviewDTO() {
		
	}
	// 생성자
	public reviewDTO(int review_idx, int v_idx, String review_content, String review_dt, String user_id) {
		super();
		this.review_idx = review_idx;
		this.v_idx = v_idx;
		this.review_content = review_content;
		this.review_dt = review_dt;
		this.user_id = user_id;
	}

	//getter/setter 메소드
	public int getReview_idx() {
		return review_idx;
	}

	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}

	public int getV_idx() {
		return v_idx;
	}

	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_dt() {
		return review_dt;
	}

	public void setReview_dt(String review_dt) {
		this.review_dt = review_dt;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

}

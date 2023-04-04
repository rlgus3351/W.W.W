package com.smhrd.model;

public class communityDTO {
	private int c_idx;
    // 글 내용 
    private String c_content;
    // 글 작성일자 
    private String c_date;
    // 글 좋아요수 
    private int c_likes;
    // 글 해시태그 
    private String c_hashtag;
    // 글 작성자 
    private String user_id;

	// 기본 생성자
	public communityDTO() {
		
	}
	// 생성자
	public communityDTO(int c_idx, String c_content, String c_date, int c_likes, String c_hashtag, String user_id) {
		super();
		this.c_idx = c_idx;
		this.c_content = c_content;
		this.c_date = c_date;
		this.c_likes = c_likes;
		this.c_hashtag = c_hashtag;
		this.user_id = user_id;
	}

	// getter/setter 메소드
	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public int getC_likes() {
		return c_likes;
	}

	public void setC_likes(int c_likes) {
		this.c_likes = c_likes;
	}

	public String getC_hashtag() {
		return c_hashtag;
	}

	public void setC_hashtag(String c_hashtag) {
		this.c_hashtag = c_hashtag;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	

}

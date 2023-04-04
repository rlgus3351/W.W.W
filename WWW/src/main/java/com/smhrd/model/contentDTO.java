package com.smhrd.model;

public class contentDTO {
	
	// 컨텐츠 번호
	private int v_idx;
	// 컨텐츠 제목(영화 제목)
	private String v_title;
	// 영화 장르
	private String v_genre;
	// 영화 방송 년도
	private int v_year;
	// 영화 시놉시스
	private String v_synopsis;
	// 영화 평점
	private double v_rating;
	// 영화 시청 등급
	private int v_grade;
	// 영화 iframe
	private String v_iframe;
	
	// 기본 생성자
	public contentDTO() {
		
	}
	// 생성자	
	public contentDTO(int v_idx, String v_title, String v_genre, int v_year, String v_synopsis, double v_rating,
			int v_grade, String v_iframe) {
		super();
		this.v_idx = v_idx;
		this.v_title = v_title;
		this.v_genre = v_genre;
		this.v_year = v_year;
		this.v_synopsis = v_synopsis;
		this.v_rating = v_rating;
		this.v_grade = v_grade;
		this.v_iframe = v_iframe;
	}
	
	// getter/setter 메소드
	public int getV_idx() {
		return v_idx;
	}
	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}
	public String getV_title() {
		return v_title;
	}
	public void setV_title(String v_title) {
		this.v_title = v_title;
	}
	public String getV_genre() {
		return v_genre;
	}
	public void setV_genre(String v_genre) {
		this.v_genre = v_genre;
	}
	public int getV_year() {
		return v_year;
	}
	public void setV_year(int v_year) {
		this.v_year = v_year;
	}
	public String getV_synopsis() {
		return v_synopsis;
	}
	public void setV_synopsis(String v_synopsis) {
		this.v_synopsis = v_synopsis;
	}
	
	public double getV_rating() {
		return v_rating;
	}

	public void setV_rating(double v_rating) {
		this.v_rating = v_rating;
	}

	public int getV_grade() {
		return v_grade;
	}
	public void setV_grade(int v_grade) {
		this.v_grade = v_grade;
	}
	public String getV_iframe() {
		return v_iframe;
	}
	public void setV_iframe(String v_iframe) {
		this.v_iframe = v_iframe;
	}
	
	
	
	
}

package com.smhrd.model;

public class memberDTO {
	
	private String user_id;
	private String user_pw;
	private String user_nick;
	private String user_gender;
	private String user_birthdate;
	private String user_joindate;
	private char user_type;
	public String getUser_id() {
		return user_id;
	}
	
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}
	public char getUser_type() {
		return user_type;
	}
	public void setUser_type(char user_type) {
		this.user_type = user_type;
	}
	
	public memberDTO() {
		
	}
	public memberDTO(String user_id, String user_pw, String user_nick, String user_gender, String user_birthdate,
			String user_joindate, char user_type) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nick = user_nick;
		this.user_gender = user_gender;
		this.user_birthdate = user_birthdate;
		this.user_joindate = user_joindate;
		this.user_type = user_type;
	}
	
	

}

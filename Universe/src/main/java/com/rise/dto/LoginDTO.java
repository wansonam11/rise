package com.rise.dto;

public class LoginDTO {
	private String userid;
	private String userpw;
	private boolean userCookie;
	
	public LoginDTO() {
		
	}

	public LoginDTO(String userid, String userpw, boolean userCookie) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.userCookie = userCookie;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public boolean isUserCookie() {
		return userCookie;
	}

	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", userpw=" + userpw + ", userCookie=" + userCookie + "]";
	}
	
}


package com.rise.domain;

public class UserVO {
	private String userid;
	private String userpw;
	private String username;
	private String userpoint;
	
	public UserVO() {
		
	}

	public UserVO(String userid, String userpw, String username, String userpoint) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userpoint = userpoint;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpoint() {
		return userpoint;
	}

	public void setUserpoint(String userpoint) {
		this.userpoint = userpoint;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userpoint=" + userpoint
				+ "]";
	}
	
}

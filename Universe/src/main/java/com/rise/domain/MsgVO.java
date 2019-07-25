package com.rise.domain;

import java.util.Date;

public class MsgVO {
	private int mid;
	private String receiver;
	private String sender;
	private String message;
	private Date opendate;
	private Date senddate;
	
	public MsgVO() {
		
	}
	
	public MsgVO(int mid, String receiver, String sender, String message, Date opendate, Date senddate) {
		super();
		this.mid = mid;
		this.receiver = receiver;
		this.sender = sender;
		this.message = message;
		this.opendate = opendate;
		this.senddate = senddate;
	}


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getOpendate() {
		return opendate;
	}


	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}


	public Date getSenddate() {
		return senddate;
	}


	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	
	
}

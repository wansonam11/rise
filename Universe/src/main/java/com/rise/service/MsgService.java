package com.rise.service;

import com.rise.domain.MsgVO;

public interface MsgService {
	
	public void addMessage(MsgVO vo)throws Exception;
	
	public MsgVO readMessage(String userid, int mid)throws Exception;
}

package com.rise.persistence;

import com.rise.domain.MsgVO;

public interface MsgDAO {
	public void create(MsgVO vo)throws Exception;
	
	public MsgVO readMessage(int mid)throws Exception;
	
	public void updateState(int mid)throws Exception;
}

package com.rise.service;

import java.util.List;

import com.rise.domain.Criteria;
import com.rise.domain.ReplyVO;

public interface ReplyService {
	
	public void addReply(ReplyVO vo)throws Exception;
	
	public List<ReplyVO> listReply(int bno)throws Exception;
	
	public void modifyReply(ReplyVO vo)throws Exception;
	
	public void removeReply(int rno)throws Exception;
	
	public List<ReplyVO> listReplyPage(int bno, Criteria cri)throws Exception;
	
	public int count(int bno)throws Exception;
}

package com.rise.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rise.domain.MsgVO;
import com.rise.persistence.MsgDAO;
import com.rise.persistence.PointDAO;

@Service
public class MsgServiceImpl implements MsgService{

	@Inject
	private MsgDAO msgDAO;
	
	@Inject
	private PointDAO pointDAO;
	
	@Transactional
	public void addMessage(MsgVO vo) throws Exception {
		System.out.println("#addMessage()");
		msgDAO.create(vo);
		pointDAO.updatePoint(vo.getSender(), 10);
	}

	public MsgVO readMessage(String userid, int mid) throws Exception {
		msgDAO.updateState(mid);
		pointDAO.updatePoint(userid, 5);
		
		return msgDAO.readMessage(mid);
	}

}

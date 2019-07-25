package com.rise.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rise.domain.MsgVO;

@Repository
public class MsgDAOImpl implements MsgDAO{
	
	@Autowired
	private SqlSession session;

	@Override
	public void create(MsgVO vo) throws Exception {
		session.insert("msg.create", vo);
		
	}

	@Override
	public MsgVO readMessage(int mid) throws Exception {
		return session.selectOne("msg.readMessage", mid);
	}

	@Override
	public void updateState(int mid) throws Exception {
		session.update("msg.updateState", mid);
	}

}
	

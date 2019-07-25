package com.rise.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rise.domain.Criteria;
import com.rise.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession session;
	
	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert("reply.create", vo);
		
	}

	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		
		return session.selectList("reply.list", bno);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update("reply.update", vo);
		
	}

	@Override
	public void delete(int rno) throws Exception {
		session.delete("reply.delete", rno);
		
	}

	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		
		RowBounds bounds = new RowBounds(cri.getPageStart(), cri.getPerPageNum());
		return session.selectList("reply.list", bno, bounds);
	}

	@Override
	public int count(int bno) throws Exception {
		
		return session.selectOne("reply.count", bno);
	}

	@Override
	public int getBno(int rno) throws Exception {
		
		return session.selectOne("reply.getBno", rno);
	}

}

package com.rise.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
    
	@Inject
	private SqlSession session;
	

	@Override 
	public boolean create(BoardVO vo) throws Exception {
		int t = session.insert("board.create", vo);
		if(t==1) return true;
		return false;
	}

	@Override
	public boolean update(BoardVO vo) throws Exception {
		int t = session.update("board.update",vo);
		if(t==1) return true;
		
		return false;
		
		
	}
	@Override
	public boolean delete(int bno) throws Exception {
		int t = session.delete("board.delete", bno);
		if(t==1) return true;
		return false;
		
		
	}
	@Override
	public BoardVO read(int bno) throws Exception {
		return session.selectOne("board.read", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return session.selectList("board.listAll");
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		RowBounds bounds = new RowBounds(cri.getPageStart(), cri.getPerPageNum());
		
		return session.selectList("board.listAll", null, bounds);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		int skip = (page - 1) * 10;
		int limit = 10;
		RowBounds bounds = new RowBounds(skip, limit);
		return session.selectList("board.listAll", null, bounds);
	}

	@Override
	public int totalCnt() throws Exception {
		
		return session.selectOne("board.totalCnt"); 
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(".countPaging",cri);
	
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		RowBounds bounds = new RowBounds(cri.getPageStart() , cri.getPerPageNum());		
		return session.selectList("board.listSearch", cri, bounds);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne("board.listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("bno", bno);
			map.put("amount", amount);
		session.update("board.updateReplyCnt", map);
			
		
	}

	@Override
	public void updateViewCnt(int bno) throws Exception {
		session.update("board.updateViewCnt", bno);
		
	}
}

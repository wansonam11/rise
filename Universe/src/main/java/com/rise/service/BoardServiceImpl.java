package com.rise.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.SearchCriteria;
import com.rise.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public boolean regist(BoardVO vo) throws Exception {
		return dao.create(vo);
		
		
	}

	@Override
	public boolean modify(BoardVO vo) throws Exception {
		return dao.update(vo);
		
	}

	@Override
	public boolean remove(int bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.delete(bno);
		
	}

	
	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
	
		return dao.listAll();	
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}

	@Override
	public int totalCnt() throws Exception {
		
		return dao.totalCnt();
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

}

package com.rise.service;

import java.util.List;
import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.SearchCriteria;

public interface BoardService {

	public boolean regist(BoardVO vo)throws Exception;
	
	public boolean modify(BoardVO vo)throws Exception;
	
	public boolean remove(int bno)throws Exception;
	
	public BoardVO read(int bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;

	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	public int listCountCriteria(Criteria cri)throws Exception;

	public int totalCnt()throws Exception;
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
	
}

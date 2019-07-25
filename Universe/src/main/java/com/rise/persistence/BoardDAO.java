package com.rise.persistence;

import java.util.List;

import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.SearchCriteria;

public interface BoardDAO {

public boolean create(BoardVO vo)throws Exception;

public boolean update(BoardVO vo)throws Exception;

public boolean delete(int bno)throws Exception;

public BoardVO read(int bno)throws Exception;

public List<BoardVO> listAll()throws Exception;

public List<BoardVO> listPage(int page)throws Exception;

public List<BoardVO> listCriteria(Criteria cri) throws Exception;

public int totalCnt()throws Exception;

public int countPaging(Criteria cri)throws Exception;

public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;

public int listSearchCount(SearchCriteria cri)throws Exception;

public void updateReplyCnt(int bno, int amount)throws Exception;

public void updateViewCnt(int bno)throws Exception;

}


package com.rise.control;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.SearchCriteria;
import com.rise.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DAOTest {

	@Inject
	private BoardDAO dao;

	@Inject
	private SqlSession session;
	
/*	@Test
	public void testListPage() throws Exception {
		List<BoardVO> list = dao.listPage(1);
		for(BoardVO board : list) {
			System.out.println("글번호: " + board.getBno());
		}
	}
	*/
	/*@Test
	public void testListCriteria() throws Exception{
		Criteria cri = new Criteria();
			cri.setPage(2);
			cri.setPerPageNum(5);
			
    	List<BoardVO> list = dao.listCriteria(cri);
    	
    	for(BoardVO board : list) {
    		System.out.println("글번호: " + board.getBno());
    		
    	}
	}*/
	
	@Test
	public void testDynamic1() throws Exception{
		SearchCriteria cri = new SearchCriteria();
			cri.setPage(1);
			cri.setKeyword("ww");
			cri.setSearchType("t");
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO board : list) {
			System.out.println("글번호: " + board.getBno() + "글제목: " + board.getTitle());;
			
			
		}
	}
	
}

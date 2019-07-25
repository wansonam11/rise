package com.rise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rise.domain.Criteria;
import com.rise.domain.PageMaker;
import com.rise.domain.ReplyVO;
import com.rise.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	  @RequestMapping(value="", method=RequestMethod.POST)	
	   public ResponseEntity<String> register(ReplyVO vo) {
	   //public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
	         //@RequestBody: 클라이언트가 전달한 JSON데이터{key:value}를  VO로 변환
		   
		   ResponseEntity<String> entity=null;
		   //entity = new ResponseEntity<String>(전달할데이터,서버상태);
		   System.out.println("댓글입력>>>"+ vo);
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);//200
		 } catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);//400
		 } 
		   return entity;
	   }
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno")int bno) {
		ResponseEntity<List<ReplyVO>> entity=null;
		try {
			List<ReplyVO> list = service.listReply(bno);
			System.out.println("결과데이터 갯수: " +  list.size());
			if(list.size() < 1) {
				entity=new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
			}else {
			entity=new ResponseEntity<List<ReplyVO>>(service.listReply(bno),HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno")int rno, @RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		try {
			vo.setRno(rno);
			service.modifyReply(vo);
			entity=new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method= {RequestMethod.DELETE})
	public ResponseEntity<String> remove(@PathVariable("rno")int rno) {
		ResponseEntity<String> entity = null;
		try {
			service.removeReply(rno);
			entity=new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public Map<String, Object> listPage(@PathVariable("bno")int bno, @PathVariable("page")int page) throws Exception {
		Criteria cri = new Criteria();
			cri.setPage(page);
			cri.setPerPageNum(3);
	
		List<ReplyVO> list = service.listReplyPage(bno, cri);		
			
		PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalcount(service.count(bno));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageMaker", maker);

		return map;
	}
}

package com.rise.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rise.domain.BoardVO;
import com.rise.domain.PageMaker;
import com.rise.domain.SearchCriteria;
import com.rise.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model m)throws Exception {
		PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalcount(service.listSearchCount(cri));
			
		m.addAttribute("list", service.listSearchCriteria(cri));
		m.addAttribute("cri", cri);	
		m.addAttribute("pageMaker", maker);
		System.out.println("리스트 페이지");
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void read(int bno, Model model, SearchCriteria cri)throws Exception {
				
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
		
		System.out.println("bno =>" + bno);
		System.out.println("readPage=>" + cri);
		//return "/sboard/list"
	}
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String removePage
	       (int bno, RedirectAttributes attr, SearchCriteria cri)throws Exception {
		service.remove(bno);
		
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("perPageNum", cri.getPerPageNum());
		attr.addAttribute("searchType", cri.getSearchType());
		attr.addAttribute("keyword", cri.getKeyword());
		
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";

	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyPagingGet(int bno, Model m, SearchCriteria cri)throws Exception{
		m.addAttribute(service.read(bno));
		 
		/*return "/sboard/modifyPage";*/

	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPagingPost(BoardVO vo, RedirectAttributes attr, SearchCriteria cri)throws Exception {
		service.modify(vo);
		
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("perPageNum", cri.getPerPageNum());
		attr.addAttribute("searchType", cri.getSearchType());
		attr.addAttribute("keyword", cri.getKeyword());
		
		attr.addFlashAttribute("msg", "SUCCESS");
		
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registGET()throws Exception {
		logger.info("regist get..........");

	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes attr)throws Exception {
		
		logger.info("등록.....");
		System.out.println("등록>> " + vo);
		
		service.regist(vo);
		attr.addFlashAttribute("msg", "SUCCESS");
		
		System.out.println(">>>msg와 SUCCESS!!!");
		
		return "redirect:/sboard/list";
	}
}

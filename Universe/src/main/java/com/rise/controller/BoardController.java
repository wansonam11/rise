package com.rise.controller;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.rise.domain.BoardVO;
import com.rise.domain.Criteria;
import com.rise.domain.PageMaker;
import com.rise.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGET()throws Exception{
		
		return "/board/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(BoardVO vo,  RedirectAttributes attr)throws Exception {
		service.regist(vo);
		attr.addFlashAttribute("result", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listAll(Model model)throws Exception {
		List<BoardVO> list = service.listAll();
			model.addAttribute("list", list);
			System.out.println(">>> data저장!!");	
		return "/board/listAll";
	}
	
	@RequestMapping(value="/read")
	public void read(int bno, Model model)throws Exception {
		
		model.addAttribute(service.read(bno));
		System.out.println("읽을 글번호 =>" + bno);
		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(int bno, Model model)throws Exception {
		model.addAttribute(service.read(bno));
		System.out.println("수정전송!");
		/*return "/board/modify";*/

	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(BoardVO vo, RedirectAttributes attr)throws Exception {
		if(service.modify(vo)) {
			attr.addFlashAttribute("msg","success");
		System.out.println("수정성공");
		}
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/remove")
	public String remove(@RequestParam("bno")int bno, RedirectAttributes attr)throws Exception {
		if(service.remove(bno)) {
			attr.addFlashAttribute("msg","success");
		}
		return "redirect:/board/listAll";
	}
	
	@RequestMapping("/listCri")  //전체 게시물 조회
	public String listAll(Criteria cri, Model m)throws Exception {
		System.out.println("특정페이지_전체게시물 조회!");
		
		m.addAttribute("list", service.listCriteria(cri));
		return "/board/listCri";
	}
	
	@RequestMapping("/listPage")
	public void listPage(Criteria cri, Model m)throws Exception {
		m.addAttribute("list", service.listCriteria(cri));
			PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalcount(service.totalCnt());
		m.addAttribute("pageMaker", maker);
		/*return "/board/listPage";*/
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(int bno, Criteria cri, Model m) throws Exception{
		System.out.println("글번호>> "+ bno);
		System.out.println("readPage cri>> "+ cri);
		
		m.addAttribute(service.read(bno));
		m.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String removePage(int bno, RedirectAttributes attr, Criteria cri) throws Exception{
		service.remove(bno);
			System.out.println("remove CRI>>> "+ cri);
	
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("perPageNum", cri.getPerPageNum());
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.GET)
	public String modifyPagingGet(int bno,Model m,
			       @ModelAttribute("cri")  Criteria cri)throws Exception{//수정폼 요청
		
		m.addAttribute(service.read(bno));
		
		return "/board/modifyPage";
	}
}

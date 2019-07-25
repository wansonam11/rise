package com.rise.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoveController {
	
	@RequestMapping("move/rise1")
	public String MoveController() {
	
		return "main";
	}
	
	@RequestMapping("move/rise2")
	public String MoveController2() {
	
		return "summary";
		
	}
	
	@RequestMapping(value="move/rise8", method=RequestMethod.GET)
	public String MoveController3() {
		
		return "Q&A";
		
	}
	
	@RequestMapping(value="move/rise8", method=RequestMethod.POST)
	public String MoveController3_2(HttpServletRequest request) {
		
		String name=request.getParameter("contents");
		request.setAttribute("rise", name);
		
		return "Q&A";
		
	}
}

package com.rise.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rise.domain.MsgVO;
import com.rise.service.MsgService;

@RestController
@RequestMapping("/msg")
public class MsgController {

	@Inject
	private MsgService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addMessage(@RequestBody MsgVO vo) throws Exception{
		
		service.addMessage(vo);
		
		return "SUCCESS";
	
	}
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String readMessage(String userid, int mid) throws Exception {
		
		service.readMessage(userid, mid);

		
		return "Success";
		

	}
}

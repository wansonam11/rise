package com.rise.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rise.domain.UserVO;
import com.rise.dto.LoginDTO;
import com.rise.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	private void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		
		System.out.println("로그인 페이지");
		

	}
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	private void loginPOST(LoginDTO dto, HttpSession session, Model m) throws Exception {
		
		UserVO vo = service.login(dto);
		
		if (vo == null) {
			return;
		}
		m.addAttribute("userVO", vo);

	}
}

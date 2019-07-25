package com.rise.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rise.domain.UserVO;
import com.rise.dto.LoginDTO;
import com.rise.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return dao.login(dto);
	}
	
}

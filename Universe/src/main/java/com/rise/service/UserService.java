package com.rise.service;

import com.rise.domain.UserVO;
import com.rise.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto)throws Exception;
	
}

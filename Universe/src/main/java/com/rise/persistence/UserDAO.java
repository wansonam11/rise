package com.rise.persistence;

import com.rise.domain.UserVO;
import com.rise.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto)throws Exception;

}

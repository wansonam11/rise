package com.rise.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rise.domain.UserVO;
import com.rise.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return session.selectOne("user.login", dto);
	}

}

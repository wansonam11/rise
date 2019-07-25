package com.rise.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{

	@Inject
	private SqlSession session;
	
	
	public void updatePoint(String userid, int point)throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("point", point);
			
		session.update("point.updatePoint", map);
	}
}

package com.lucifer.dao.cms;

import com.lucifer.utils.IdUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class IBatisBaseDao {	
	//config
	@Autowired
	@Qualifier("userSqlSessionTemplate")
	protected SqlSession userSqlSession;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Resource
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	
	public Long nextId(String sequence){
		return stringRedisTemplate.opsForValue().increment(sequence, 1L);
	}

	public Long nextId(){
		return IdUtil.nextId();
	}
		
}

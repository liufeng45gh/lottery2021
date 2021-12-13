package com.lucifer.service.cms;



import com.lucifer.dao.cms.UserBlockDao;
import com.lucifer.model.user.UserBlock;
import com.lucifer.model.user.UserBlockSearchParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBlockService {
	
	@Resource
	private UserBlockDao userBlockDao;
	
	public List<UserBlock> userBLockList(UserBlockSearchParam userBlockSearchParam, Integer page, Integer count){
		return userBlockDao.getUserBlockList(userBlockSearchParam, page, count);
	}
	
	

}

package com.lucifer.service.cms;


import com.lucifer.exception.Oauth2CodeInvalidException;
import com.lucifer.exception.Oauth2LoginException;
import com.lucifer.mapper.oauth2.UserMapper;
import com.lucifer.model.user.AccessToken;
import com.lucifer.model.user.User;
import com.lucifer.utils.Md5Utils;
import com.lucifer.utils.Result;
import com.lucifer.utils.StringHelper;

import org.apache.commons.lang.RandomStringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserLoginService {

	
	@Resource
	private UserService userService;
	
	@Resource
	private UserMapper userMapper;


	final Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * 总登陆接口
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public Result login(User user) throws Exception{
		if (!StringHelper.isEmpty(user.getPhone())) {//手机号登录
			return this.loginByPhone(user);
		}

		return Result.fail();
	}
	
	/**
	 * 手机号登录
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public Result loginByPhone(User user) throws Exception{

		User dbUser = userMapper.getUserByPhone(user.getPhone());
		if  (null == dbUser)  {
			return Result.fail("用户未找到");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
		if (!md5Password.equals(dbUser.getPassword())) {
			return Result.fail("密码错误");
		}

		AccessToken accessToken = this.newUserLoginToken(dbUser.getId());
		return this.loginSuccess(dbUser,accessToken.getToken());
//		dbUser.setPassword(user.getPassword());
		//user.setPassword(Md5Utils.md5(user.getPassword()));
		
//		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
//		if (md5Password.equals(dbUser.getPassword())) {
//			
//		}		
//		return Result.fail("密码错误");
	}

	public AccessToken newUserLoginToken(Long userId){
		AccessToken accessToken = new AccessToken();
		String token = RandomStringUtils.randomAlphanumeric(20);
		String code = RandomStringUtils.randomAlphanumeric(20);
		accessToken.setToken(token);
		accessToken.setUserId(userId);
		accessToken.setCode(code);

		this.userMapper.insertUserLoginToken(accessToken);
		return accessToken;
	}

	/**
	 * 手机号登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public AccessToken oauth2LoginByAccount(User user) throws Exception{

		User dbUser = userMapper.getUserByAccount(user.getAccount());
		if  (null == dbUser)  {
			throw new Oauth2LoginException("用户未找到");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
		if (!md5Password.equals(dbUser.getPassword())) {
			throw new Oauth2LoginException("密码错误");
		}

		AccessToken accessToken = this.newUserLoginToken(dbUser.getId());
		return accessToken;
//		dbUser.setPassword(user.getPassword());
		//user.setPassword(Md5Utils.md5(user.getPassword()));

//		String md5Password = Md5Utils.md5(Md5Utils.md5(user.getPassword())+dbUser.getSalt());
//		if (md5Password.equals(dbUser.getPassword())) {
//
//		}
//		return Result.fail("密码错误");
	}



	/**
	 * 返回token
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	public Result loginSuccess(User user, String token) throws IOException{
		//String token = RandomStringUtils.randomAlphanumeric(20);
		//stringRedisTemplate.opsForValue().set(RedisKeyPreConstant.USER_TOKEN_PRE+token, user.getUserId().toString());
		//stringRedisTemplate.expire(RedisKeyPreConstant.USER_TOKEN_PRE+token, 10, TimeUnit.DAYS);
		Map resultMap = new HashMap();
		resultMap.put("user", user);
		resultMap.put("token", token);
		user.setPassword(null);
		return Result.ok(resultMap);
	}
	



	
	public void logout(String token){
//		stringRedisTemplate.delete(RedisKeyPreConstant.USER_TOKEN_PRE+token);
		userMapper.removeToken(token);
	}

	public AccessToken loginByCode(String code) throws Oauth2CodeInvalidException {
		AccessToken accessToken =  userMapper.getAccessTokenByCode(code);
		if (null == accessToken) {
			throw new Oauth2CodeInvalidException("code 无效");
		}
		logger.info("accessToken is : "+accessToken);
		logger.info("accessToken.getCodeLogin() is : "+accessToken.getCodeLogin());
		if (new Integer(1).equals(accessToken.getCodeLogin())) {
			throw new Oauth2CodeInvalidException("code 已登录");
		}
		userMapper.setCodeInvalid(code);
		return  accessToken;
	}

	public AccessToken getAccessTokenByToken(String accessToken){
		return userMapper.getAccessTokenByToken(accessToken);
	}

	public Result cmsLoginByAccount(String account, String password) throws Exception{
		User dbUser = userMapper.getUserByAccount(account);
		if  (null == dbUser)  {
			return Result.fail("用户未找到");
		}
		String md5Password = Md5Utils.md5(Md5Utils.md5(password)+dbUser.getSalt());
		logger.info("md5Password: "+md5Password);
		if (!md5Password.equals(dbUser.getPassword())) {
			return Result.fail("密码错误");
		}
		return Result.ok(dbUser);
	}

}

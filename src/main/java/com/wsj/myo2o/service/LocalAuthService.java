package com.wsj.myo2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wsj.myo2o.dto.LocalAuthExecution;
import com.wsj.myo2o.entity.LocalAuth;

public interface LocalAuthService {
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	LocalAuth getLocalAuthByUsernameAndPwd(String username, String password);
	/**
	 * 登录
	 * @param userId
	 * @return
	 */
	LocalAuth getLocalAuthByUserId(long userId);
	/**
	 * 注册
	 * @param localAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution register(LocalAuth localAuth, CommonsMultipartFile profileImg) throws RuntimeException;
	/**
	 * 绑定账号
	 * @param localAuth
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution bindLocalAuth(LocalAuth localAuth)throws RuntimeException;
	/**
	 * 更新密码
	 * @param userId
	 * @param username
	 * @param password
	 * @param newPassword
	 * @return
	 */
	LocalAuthExecution modifyLocalAuth(Long userId, String username,
			String password, String newPassword);
}

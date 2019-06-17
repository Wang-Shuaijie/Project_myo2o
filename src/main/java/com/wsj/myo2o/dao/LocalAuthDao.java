package com.wsj.myo2o.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.wsj.myo2o.entity.LocalAuth;

public interface LocalAuthDao {
	/**
	 * 通过用户名和密码查找本地账号
	 * @param username
	 * @param password
	 * @return
	 */
	LocalAuth queryLocalByUsernameAndPwd(@Param("username") String username,
			@Param("password") String password);
	/**
	 * 根据个人信息id查找本地账户
	 * @param userId
	 * @return
	 */
	LocalAuth queryLocalByUserId(@Param("userId") long userId);
	/**
	 * 添加
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAuth localAuth);
	/**
	 * 更新密码
	 * @param localAuth
	 * @return
	 */
	int updateLocalAuth(@Param("userId") Long userId,
			@Param("username") String username,
			@Param("password") String password,
			@Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime);
}

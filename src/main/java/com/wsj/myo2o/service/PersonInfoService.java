package com.wsj.myo2o.service;

import com.wsj.myo2o.dto.PersonInfoExecution;
import com.wsj.myo2o.entity.PersonInfo;

public interface PersonInfoService {
	/**
	 * 根据用户id查找用户信息
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfo(Long userId);
	/**
	 * 模糊查询，并分页展示
	 * @param personInfoCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition,int pageIndex, int pageSize);
	/**
	 * 添加用户信息
	 * @param personInfo
	 * @return
	 */
	PersonInfoExecution addPersonInfo(PersonInfo personInfo);
	/**
	 * 更新用户信息
	 * @param personInfo
	 * @return
	 */
	PersonInfoExecution modifyPersonInfo(PersonInfo personInfo);
}

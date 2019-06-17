package com.wsj.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsj.myo2o.entity.PersonInfo;

public interface PersonInfoDao {
	//@Param 注解的用处
	//1.接口中方法只有一个参数，不用使用@Param，对应xml文件中，#{}中可以填写任意名称
	//2.接口中方法有多个参数，需要用@Param注解进行参数绑定，#{}中可以填写对应名
	
	
	/**
	 * 模糊查询个人信息并分页
	 * @param personInfoCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<PersonInfo> queryPersonInfoList(
			@Param("personInfoCondition") PersonInfo personInfoCondition,
			@Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);
	/**
	 * 查询总数
	 * @param personInfoCondition
	 * @return
	 */
	int queryPersonInfoCount(@Param("personInfoCondition")PersonInfo personInfoCondition);
	/**
	 * 根据id查找个人信息
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);
	
	int insertPersonInfo(PersonInfo personInfo);
	int updatePersonInfo(PersonInfo personInfo);
	int deletePersonInfo(long userId);
}

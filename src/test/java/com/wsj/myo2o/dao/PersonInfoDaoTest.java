package com.wsj.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.PersonInfo;

public class PersonInfoDaoTest extends BaseTest{
	
	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void queryPersonInfoCount() {
		System.out.println(personInfoDao.queryPersonInfoCount(new PersonInfo()));
	}
	
	@Test
	public void testInsertPersonInfo() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("test");
		personInfo.setGender("男");
		personInfo.setUserType(1);
		personInfo.setEnableStatus(1);
		int effectedNum = personInfoDao.insertPersonInfo(personInfo);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testQueryPersonInfoList() {
		PersonInfo personInfo=new PersonInfo();
		List<PersonInfo> personInfoList=personInfoDao.queryPersonInfoList(personInfo, 0, 10);
		for(PersonInfo p:personInfoList) {
			System.out.println(p.getName());
		}
	}
	
	@Test
	public void testUpdatePersonInfo() {
		PersonInfo personInfo = new PersonInfo();
		long userId = 1;
		personInfo.setUserId(userId);
		personInfo.setGender("男");
		int effectedNum = personInfoDao.updatePersonInfo(personInfo);
		assertEquals(1, effectedNum);
	}
}

package com.wsj.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.LocalAuth;

public class LocalAuthDaoTest extends BaseTest{
	@Autowired
	private LocalAuthDao localAuthDao;
	
	@Test
	//@Transactional
	public void testInsertLocalAuth() {
		LocalAuth localAuth=new LocalAuth();
		localAuth.setUserId(1L);
		localAuth.setUsername("SoulKnight");
		localAuth.setPassword("123");
		localAuth.setCreateTime(new Date());
		localAuth.setLastEditTime(new Date());
		int effectedNum=localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testUpdateLocalAuth() {
		int effectedNum=localAuthDao.updateLocalAuth(1L, "SoulKnight", "123456", "123", new Date());
		assertEquals(1, effectedNum);
	}

}

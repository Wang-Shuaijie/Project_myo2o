package com.wsj.myo2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest{
	@Autowired 
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> list=shopCategoryDao.queryShopCategory(new ShopCategory());
		for(ShopCategory c:list) {
			System.out.println(c.getShopCategoryName());
		}
	}
}

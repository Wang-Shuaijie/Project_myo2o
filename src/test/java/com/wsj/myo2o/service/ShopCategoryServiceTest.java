package com.wsj.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.dto.ShopCategoryExecution;
import com.wsj.myo2o.dto.ShopExecution;
import com.wsj.myo2o.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest{
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	/*@Test
	public void testGetShopCategoryList() {
		List<ShopCategory> list=shopCategoryService.getShopCategoryList(new ShopCategory());
		for(ShopCategory c:list) {
			System.out.println(c.getShopCategoryName());
		}
	}*/
	
	@Test
	public void testFirstLevelShopCategoryList() throws IOException {
		List<ShopCategory> list=shopCategoryService.getFirstLevelShopCategoryList();
		for(ShopCategory c:list) {
			System.out.println(c.getShopCategoryName());
		}
	}
	
	@Test
	public void testAllSecondLevelShopCategory() throws IOException {
		List<ShopCategory> list=shopCategoryService.getAllSecondLevelShopCategory();
		for(ShopCategory c:list) {
			System.out.println(c.getShopCategoryName());
		}
	}
	
	@Test
	public void addShopCategory() {
		ShopCategory sc=null;
		ShopCategoryExecution shopCategoryExecution=shopCategoryService.addShopCategory(sc, null);
		System.out.println(shopCategoryExecution.getStateInfo());
	}
}

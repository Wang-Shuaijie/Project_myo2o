package com.wsj.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.Area;
import com.wsj.myo2o.entity.PersonInfo;
import com.wsj.myo2o.entity.Shop;
import com.wsj.myo2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testInsertShop() {
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		ShopCategory shopCategory=new ShopCategory();
		Area area=new Area();
		owner.setUserId(1L);
		area.setAreaId(1L);
		shopCategory.setShopCategoryId(10L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("test");
		shop.setShopDesc("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setPriority(0);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		
		int effectedNum=shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	
	@Test
	public void testUpdateShop() {
		Shop shop=new Shop();
		shop.setShopId(6L);
		shop.setShopName("test");
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		ShopCategory shopCategory=new ShopCategory();
		ShopCategory parentCategory=new ShopCategory();
		parentCategory.setShopCategoryId(10L);
		shopCategory.setShopCategoryId(15L);
		shopCategory.setParentId(10L);
		shop.setParentCategory(parentCategory);
		shop.setShopCategory(shopCategory);
		
		int effectedNum=shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testqueryShopCount() {
		System.out.println(shopDao.queryShopCount(new Shop()));
	}
	
	@Test
	public void testQueryShopList() {
		Shop shop=new Shop();
		List<Shop> shopList = shopDao.queryShopList(shop, 0, 2);
		System.out.println(shopList.size());
	}
	
}

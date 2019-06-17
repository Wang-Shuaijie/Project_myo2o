package com.wsj.myo2o.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.dto.ShopExecution;
import com.wsj.myo2o.entity.Area;
import com.wsj.myo2o.entity.PersonInfo;
import com.wsj.myo2o.entity.Shop;
import com.wsj.myo2o.entity.ShopCategory;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testAddShop() {
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
		shop.setShopName("test2");
		shop.setShopDesc("测试店铺2");
		shop.setPhone("test");
		ShopExecution se = shopService.addShop(shop, null);
		System.out.println(se.getState()+"\n"+se.getShop().getShopName());
	}
}

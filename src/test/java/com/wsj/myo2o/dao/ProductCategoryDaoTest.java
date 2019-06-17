package com.wsj.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	public void testInsertProductCategory() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setProductCategoryDesc("测试商品类别1");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setLastEditTime(new Date());
		productCategory.setShopId(6L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setProductCategoryDesc("测试商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setLastEditTime(new Date());
		productCategory2.setShopId(6L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
	}
	
	@Test
	public void testQueryShopId() {
		long shopId = 6;
		List<ProductCategory> productCategoryList = productCategoryDao.queryByShopId(shopId);
		for(ProductCategory pc:productCategoryList) {
			System.out.println(pc.getProductCategoryName());
		}
	}
}

package com.wsj.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.Product;
import com.wsj.myo2o.entity.ProductCategory;
import com.wsj.myo2o.entity.Shop;

public class ProductDaoTest extends BaseTest{
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testInsertProduct() {
		Shop shop=new Shop();
		shop.setShopId(6L);
		ProductCategory productCategory=new ProductCategory();
		productCategory.setProductCategoryId(1L);
		Product product=new Product();
		product.setProductName("测试1");
		product.setProductDesc("测试Desc1");
		product.setImgAddr("test1");
		product.setPriority(0);
		product.setEnableStatus(1);
		product.setCreateTime(new Date());
		product.setLastEditTime(new Date());
		product.setShop(shop);
		product.setProductCategory(productCategory);
		int effectedNum = productDao.insertProduct(product);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testQueryProductList() throws Exception{
		Product product = new Product();
		List<Product> productList = productDao.queryProductList(product, 0, 3);
		for(Product p:productList) {
			System.out.println(p.getProductId());
			System.out.println(p.getProductName());
		}
	}
	
	@Test
	public void testQueryProductCount() {
		int count=productDao.queryProductCount(new Product());
		System.out.println(count);
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		Product product = new Product();
		product.setProductId(1L);
		product.setProductName("第一个测试产品");
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}
}

package com.wsj.myo2o.service;

import java.util.List;

import com.wsj.myo2o.dto.ProductCategoryExecution;
import com.wsj.myo2o.entity.ProductCategory;

public interface ProductCategoryService {
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> getByShopId(long shopId);
	/**
	 * 增加商品类别
	 * @param productCategoryList
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws RuntimeException;
	/**
	 * 删除商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws RuntimeException;
}

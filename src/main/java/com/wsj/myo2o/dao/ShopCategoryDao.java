package com.wsj.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsj.myo2o.entity.ShopCategory;

public interface ShopCategoryDao {
	/**
	 * 根据传入的参数列出类型
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(
			@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
	/**
	 * 根据id查找类型
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategory queryShopCategoryById(long shopCategoryId);
	/**
	 * 根据id的list集合查找所有类型
	 * @param shopCategoryIdList
	 * @return
	 */
	List<ShopCategory> queryShopCategoryByIds(List<Long> shopCategoryIdList);
	/**
	 * 
	 * @param shopCategory
	 * @return
	 */
	int insertShopCategory(ShopCategory shopCategory);

	/**
	 * 
	 * @param shopCategory
	 * @return
	 */
	int updateShopCategory(ShopCategory shopCategory);

	/**
	 * 
	 * @param shopCategoryId
	 * @return
	 */
	int deleteShopCategory(long shopCategoryId);

	/**
	 * 
	 * @param shopCategoryIdList
	 * @return
	 */
	int batchDeleteShopCategory(List<Long> shopCategoryIdList);
}

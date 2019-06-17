package com.wsj.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wsj.myo2o.dto.ShopCategoryExecution;
import com.wsj.myo2o.entity.ShopCategory;

public interface ShopCategoryService {
	//测试
	//List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
	
	/**
	 * 查询指定某个店铺下的所有商品一级类别信息
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;

	/**
	 * 查询某个父类型下所有的子类型
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(Long parentId) throws IOException;

	/**
	 * 查询所有的二级类型
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

	/**
	 * 根据类型id查找类别信息
	 * @param shopCategory
	 * @return
	 */
	ShopCategory getShopCategoryById(Long shopCategoryId);

	/**
	 * 添加店铺类型
	 * @param shopCategory
	 * @param thumbnail
	 * @return
	 */
	ShopCategoryExecution addShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail);

	/**
	 * 更新店铺类型
	 * @param shopCategory
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
	ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail, boolean thumbnailChange);

	/**
	 * 移除店铺类型
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategoryExecution removeShopCategory(long shopCategoryId);

	/**
	 * 移除较多店铺类型
	 * @param shopCategoryIdList
	 * @return
	 */
	ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList);
}

package com.wsj.myo2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wsj.myo2o.dto.ShopExecution;
import com.wsj.myo2o.entity.Shop;

public interface ShopService {
	/**
	 * 模糊查询
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopExecution getShopList(Shop shopCondition,int pageIndex, int pageSize);
	/**
	 * 查询指定店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	/**
	 * 添加商品
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
	/**
	 * 更新店铺信息
	 * @param shop
	 * @param shopImg
	 * @return
	 * @throws RuntimeException
	 */
	ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;
}

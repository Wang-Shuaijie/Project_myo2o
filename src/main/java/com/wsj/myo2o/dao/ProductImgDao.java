package com.wsj.myo2o.dao;

import java.util.List;

import com.wsj.myo2o.entity.ProductImg;

public interface ProductImgDao {
	/**
	 * 通过商品id查找所有商品图片
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);
	/**
	 * 添加商品图片
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	/**
	 * 删除商品图片
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
}

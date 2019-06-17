package com.wsj.myo2o.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wsj.myo2o.dto.ProductExecution;
import com.wsj.myo2o.entity.Product;

public interface ProductService {
	/**
	 * 模糊查询，并分页展示
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
	/**
	 * 根据商品id查找商品
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);
	/**
	 * 添加商品
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws RuntimeException
	 */
	ProductExecution addProduct(Product product, CommonsMultipartFile thumbnail, List<CommonsMultipartFile> productImgs)
			throws RuntimeException;
	/**
	 * 更新商品
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws RuntimeException
	 */
	ProductExecution modifyProduct(Product product, CommonsMultipartFile thumbnail,
			List<CommonsMultipartFile> productImgs) throws RuntimeException;
}

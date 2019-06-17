package com.wsj.myo2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wsj.myo2o.dao.ShopCategoryDao;
import com.wsj.myo2o.dto.ShopCategoryExecution;
import com.wsj.myo2o.entity.ShopCategory;
import com.wsj.myo2o.enums.ShopCategoryStateEnum;
import com.wsj.myo2o.service.ShopCategoryService;
import com.wsj.myo2o.util.FileUtil;
import com.wsj.myo2o.util.ImageUtil;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	/*@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// TODO Auto-generated method stub
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}*/
	
	@Override
	public List<ShopCategory> getFirstLevelShopCategoryList() throws IOException {
		ShopCategory shopCategoryCondition = new ShopCategory();
		// 当shopCategoryId不为空的时候，查询的条件会变为 where parent_id is null
		shopCategoryCondition.setShopCategoryId(-1L);
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

	@Override
	public List<ShopCategory> getShopCategoryList(Long parentId) throws IOException {
		ShopCategory shopCategoryCondition=new ShopCategory();
		shopCategoryCondition.setParentId(parentId);
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

	@Override
	public List<ShopCategory> getAllSecondLevelShopCategory() throws IOException {
		ShopCategory shopCategoryCondition=new ShopCategory();
		// 当shopCategoryDesc不为空的时候，查询的条件会变为 where parent_id is not null
		shopCategoryCondition.setShopCategoryDesc("ALLSECOND");
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

	@Override
	public ShopCategory getShopCategoryById(Long shopCategoryId) {
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		try {
			shopCategoryList = getFirstLevelShopCategoryList();
			shopCategoryList.addAll(getAllSecondLevelShopCategory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (ShopCategory sc : shopCategoryList) {
			if (shopCategoryId == sc.getShopCategoryId()) {
				return sc;
			}
		}
		ShopCategory sc = shopCategoryDao.queryShopCategoryById(shopCategoryId);
		if (sc != null) {
			return sc;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public ShopCategoryExecution addShopCategory(ShopCategory shopCategory, CommonsMultipartFile thumbnail) {
		if (shopCategory != null) {
			shopCategory.setCreateTime(new Date());
			shopCategory.setLastEditTime(new Date());
			if (thumbnail != null) {
				addThumbnail(shopCategory, thumbnail);
			}
			try {
				int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
				if (effectedNum > 0) {
					return new ShopCategoryExecution(
							ShopCategoryStateEnum.SUCCESS, shopCategory);
				} else {
					return new ShopCategoryExecution(
							ShopCategoryStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("添加店铺类别信息失败:" + e.toString());
			}
		} else {
			return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, CommonsMultipartFile thumbnail,
			boolean thumbnailChange) {
		if (shopCategory.getShopCategoryId() != null
				&& shopCategory.getShopCategoryId() > 0) {
			shopCategory.setLastEditTime(new Date());
			if (thumbnail != null && thumbnailChange == true) {
				ShopCategory tempShopCategory = shopCategoryDao
						.queryShopCategoryById(shopCategory.getShopCategoryId());
				if (tempShopCategory.getShopCategoryImg() != null) {
					FileUtil.deleteFile(tempShopCategory.getShopCategoryImg());
				}
				addThumbnail(shopCategory, thumbnail);
			}
			try {
				int effectedNum = shopCategoryDao
						.updateShopCategory(shopCategory);
				if (effectedNum > 0) {
					return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS, shopCategory);
				} else {
					return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("更新店铺类别信息失败:" + e.toString());
			}
		} else {
			return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public ShopCategoryExecution removeShopCategory(long shopCategoryId) {
		if (shopCategoryId > 0) {
			try {
				ShopCategory tempShopCategory = shopCategoryDao.queryShopCategoryById(shopCategoryId);
				if (tempShopCategory.getShopCategoryImg() != null) {
					FileUtil.deleteFile(tempShopCategory.getShopCategoryImg());
				}
				int effectedNum = shopCategoryDao
						.deleteShopCategory(shopCategoryId);
				if (effectedNum > 0) {
					return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS);
				} else {
					return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("删除店铺类别信息失败:" + e.toString());
			}
		} else {
			return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList) {
		if (shopCategoryIdList != null && shopCategoryIdList.size() > 0) {
			try {
				List<ShopCategory> shopCategoryList = shopCategoryDao
						.queryShopCategoryByIds(shopCategoryIdList);
				for (ShopCategory shopCategory : shopCategoryList) {
					if (shopCategory.getShopCategoryImg() != null) {
						FileUtil.deleteFile(shopCategory.getShopCategoryImg());
					}
				}
				int effectedNum = shopCategoryDao.batchDeleteShopCategory(shopCategoryIdList);
				if (effectedNum > 0) {
					return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS);
				} else {
					return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("删除店铺类别信息失败:" + e.toString());
			}
		} else {
			return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
		}
	}

	private void addThumbnail(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail) {
		String dest = FileUtil.getShopCategoryImagePath();
		String thumbnailAddr = ImageUtil.generateNormallmg(thumbnail, dest);
		shopCategory.setShopCategoryImg(thumbnailAddr);
	}
}

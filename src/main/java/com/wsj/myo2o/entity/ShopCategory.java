package com.wsj.myo2o.entity;

import java.util.Date;

/**
 * shop类型实体类
 * @author WangShuaiJie
 *
 */
public class ShopCategory {
	//id
	private Long shopCategoryId;
	//父类型id
	private Long parentId;
	//类型名
	private String shopCategoryName;
	//类型描述
	private String shopCategoryDesc;
	//类型图片
	private String shopCategoryImg;
	//权重
	private Integer priority;
	//创建时间
	private Date createTime;
	//最后修改时间
	private Date lastEditTime;
	
	//父类型
	private ShopCategory parentCategory;
	
	public Long getShopCategoryId() {
		return shopCategoryId;
	}
	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getShopCategoryName() {
		return shopCategoryName;
	}
	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}
	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}
	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}
	public String getShopCategoryImg() {
		return shopCategoryImg;
	}
	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public ShopCategory getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(ShopCategory parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	
}

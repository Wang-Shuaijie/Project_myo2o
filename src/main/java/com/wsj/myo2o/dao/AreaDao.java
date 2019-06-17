package com.wsj.myo2o.dao;

import java.util.List;

import com.wsj.myo2o.entity.Area;

/**
 * area dao层
 * @author WangShuaiJie
 *
 */
public interface AreaDao {
	/**
	 * 列出区域列表
	 * @return
	 */
	List<Area> queryArea();
	/**
	 * 
	 * @param area
	 * @return
	 */
	int insertArea(Area area);

	/**
	 * 
	 * @param area
	 * @return
	 */
	int updateArea(Area area);

	/**
	 * 
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);

	/**
	 * 
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
}

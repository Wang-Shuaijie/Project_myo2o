package com.wsj.myo2o.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wsj.myo2o.dto.AreaExecution;
import com.wsj.myo2o.entity.Area;

public interface AreaService {
	/**
	 * 查询所有区域
	 * @return
	 */
	List<Area> getAreaList() throws JsonParseException, JsonMappingException,IOException;
	/**
	 * 添加区域
	 * @param area
	 * @return
	 */
	AreaExecution addArea(Area area);
	/**
	 * 更新区域
	 * @param area
	 * @return
	 */
	AreaExecution modifyArea(Area area);
	/**
	 * 删除区域
	 * @param areaId
	 * @return
	 */
	AreaExecution removeArea(Long areaId);
	/**
	 * 批量删除
	 * @param areaIdList
	 * @return
	 */
	AreaExecution removeAreaList(List<Long> areaIdList);
}

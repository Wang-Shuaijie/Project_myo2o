package com.wsj.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsj.myo2o.entity.HeadLine;

public interface HeadLineDao {
	/**
	 * 模糊查询
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
	/**
	 * 根据id查询
	 * @param lineId
	 * @return
	 */
	HeadLine queryHeadLineById(long lineId);
	/**
	 * 
	 * @param lineIdList
	 * @return
	 */
	List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);
	/**
	 * 增
	 * @param headLine
	 * @return
	 */
	int insertHeadLine(HeadLine headLine);
	/**
	 * 改
	 * @param headLine
	 * @return
	 */
	int updateHeadLine(HeadLine headLine);
	/**
	 * 删
	 * @param headLineId
	 * @return
	 */
	int deleteHeadLine(long headLineId);
	/**
	 * 批量删
	 * @param lineIdList
	 * @return
	 */
	int batchDeleteHeadLine(List<Long> lineIdList);
}

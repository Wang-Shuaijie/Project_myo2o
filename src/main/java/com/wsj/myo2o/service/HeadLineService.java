package com.wsj.myo2o.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wsj.myo2o.dto.HeadLineExecution;
import com.wsj.myo2o.entity.HeadLine;

public interface HeadLineService {
	/**
	 * 模糊查询
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition);
	/**
	 * 添加头条
	 * @param headLine
	 * @param thumbnail
	 * @return
	 */
	HeadLineExecution addHeadLine(HeadLine headLine, CommonsMultipartFile thumbnail);
	/**
	 * 修改
	 * @param headLine
	 * @param thumbnail
	 * @return
	 */
	HeadLineExecution modifyHeadLine(HeadLine headLine, CommonsMultipartFile thumbnail);
	/**
	 * 移除
	 * @param headLineId
	 * @return
	 */
	HeadLineExecution removeHeadLine(long headLineId);
	/**
	 * 大量移除
	 * @param headLineIdList
	 * @return
	 */
	HeadLineExecution removeHeadLineList(List<Long> headLineIdList);
}

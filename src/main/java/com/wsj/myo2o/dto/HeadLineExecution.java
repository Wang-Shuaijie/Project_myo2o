package com.wsj.myo2o.dto;

import java.util.List;

import com.wsj.myo2o.entity.HeadLine;
import com.wsj.myo2o.enums.HeadLineStateEnum;

public class HeadLineExecution {
	//结果状态
	private int state;
	//结果状态标识
	private String stateInfo;
	
	private int count;
	
	private HeadLine headLine;
	
	private List<HeadLine> headLinelList;
	
	public HeadLineExecution() {
		
	}
	
	public HeadLineExecution(HeadLineStateEnum stateEnum) {
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
	}
	
	public HeadLineExecution(HeadLineStateEnum stateEnum, HeadLine headLine) {
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
		this.headLine=headLine;
	}
	
	public HeadLineExecution(HeadLineStateEnum stateEnum, List<HeadLine> headLineList) {
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
		this.headLinelList=headLineList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public HeadLine getHeadLine() {
		return headLine;
	}

	public void setHeadLine(HeadLine headLine) {
		this.headLine = headLine;
	}

	public List<HeadLine> getHeadLinelList() {
		return headLinelList;
	}

	public void setHeadLinelList(List<HeadLine> headLinelList) {
		this.headLinelList = headLinelList;
	}
	
}

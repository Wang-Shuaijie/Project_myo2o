package com.wsj.myo2o.dto;

import java.util.List;

import com.wsj.myo2o.entity.Area;
import com.wsj.myo2o.enums.AreaStateEnum;
/**
 * 使用枚举表述常量数据字典
 * @author WangShuaiJie
 *
 */
public class AreaExecution {
	//结果状态
	private int state;
	//状态标识
	private String stateInfo;
	//数量
	private int count;
	//要操作的实体
	private Area area;
	//获取area列表
	private List<Area> areaList;
	
	public AreaExecution() {
		
	}
	//失败的构造器
	public AreaExecution(AreaStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	//成功的构造器
	public AreaExecution(AreaStateEnum stateEnum, Area area) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.area=area;
	}
	//成功的构造器
	public AreaExecution(AreaExecution stateEnum, List<Area> areaList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.areaList=areaList;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

}

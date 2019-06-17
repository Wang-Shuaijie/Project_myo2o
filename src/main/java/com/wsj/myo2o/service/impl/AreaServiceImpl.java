package com.wsj.myo2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.myo2o.dao.AreaDao;
import com.wsj.myo2o.dto.AreaExecution;
import com.wsj.myo2o.entity.Area;
import com.wsj.myo2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

	@Override
	public AreaExecution addArea(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaExecution modifyArea(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaExecution removeArea(Long areaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaExecution removeAreaList(List<Long> areaIdList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

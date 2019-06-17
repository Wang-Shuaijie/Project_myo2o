package com.wsj.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wsj.myo2o.BaseTest;
import com.wsj.myo2o.entity.Area;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() throws JsonParseException, JsonMappingException, IOException {
		List<Area> list=areaService.getAreaList();
		for(Area area:list) {
			System.out.println(area.getAreaName());
		}
	}
}

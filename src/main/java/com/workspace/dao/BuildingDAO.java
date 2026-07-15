package com.workspace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.workspace.dto.BuildingDTO;
import com.workspace.mapper.BuildingMapper;

@Repository
public class BuildingDAO 
{
	private final BuildingMapper buildingMapper;
	
	public BuildingDAO(BuildingMapper buildingMapper) 
	{
		this.buildingMapper = buildingMapper;
	}
	
	public List<BuildingDTO> getAllBuildings(int offset , int size,String search,
			Integer siteId, Integer locationId,String sort) 
	{
		return buildingMapper.getAllBuildings(offset,size,search,siteId,locationId,sort);
	}
	
	public BuildingDTO getBuildingById(int id) 
	{
		return buildingMapper.getBuildingById(id);
	}
	
	public void addBuilding(BuildingDTO buildingDTO) 
	{
		buildingMapper.addBuilding(buildingDTO);
	}
	
	public int updateBuilding(BuildingDTO buildingDTO) 
	{
		return buildingMapper.updateBuilding(buildingDTO);
	}
	
	public int deleteBuilding(int id) 
	{
		return buildingMapper.deleteBuilding(id);
	}

}

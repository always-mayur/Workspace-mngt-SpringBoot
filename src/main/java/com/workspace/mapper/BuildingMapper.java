package com.workspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.workspace.dto.BuildingDTO;

@Mapper
public interface BuildingMapper 
{
	List<BuildingDTO> getAllBuildings(@Param("offset") int offset,
	        @Param("size") int size,@Param("search") String search,
	        @Param("siteId") Integer siteId,@Param("locationId") Integer locationId,
	        @Param("sort") String sort);
	
	BuildingDTO getBuildingById(int id);
	
	void addBuilding(BuildingDTO buildingDTO);
	
	int updateBuilding(BuildingDTO buildingDTO);
	
	int deleteBuilding(int id);

}

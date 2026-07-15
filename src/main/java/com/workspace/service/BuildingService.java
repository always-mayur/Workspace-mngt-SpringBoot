package com.workspace.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.workspace.dao.BuildingDAO;
import com.workspace.dao.SiteDAO;
import com.workspace.dto.BuildingDTO;
import com.workspace.dto.SiteDTO;
import com.workspace.exception.ResourceNotFoundException;

@Service
public class BuildingService 
{
    private final BuildingDAO buildingDAO;
    
    private final SiteDAO siteDAO;
    
    public BuildingService(SiteDAO siteDAO, BuildingDAO buildingDAO) 
	{
		this.siteDAO = siteDAO;
		this.buildingDAO = buildingDAO;
	}
    
    private static final Logger logger =
    		LoggerFactory.getLogger(BuildingService.class);
    
    public List<BuildingDTO> getAllBuildings(int page,int size,String search,
    		Integer siteId,Integer locationId,String sort)
    {
    	int offset = page * size;
    	
    	
    	return buildingDAO.getAllBuildings(offset,size,search,siteId,locationId,sort);
    }
    
    public BuildingDTO getBuildingById(int id)
	{
		return buildingDAO.getBuildingById(id);
	}
    
    @Transactional
    public void addBuilding(BuildingDTO buildingDTO) 
	{
    	logger.info("Adding building: {}", buildingDTO.getBuildingName());
    	SiteDTO site = siteDAO.getSiteById(buildingDTO.getSiteId());
    	
    	if (site == null) 
		{
    		   logger.error(
    		            "Site {} not found",
    		            buildingDTO.getSiteId());
			throw new ResourceNotFoundException("Site with id " + buildingDTO.getSiteId() + " not found");
		}
    	
    	
		buildingDAO.addBuilding(buildingDTO);
	    //throw new RuntimeException("Testing Transaction");
		logger.info(
			    "Building '{}' added successfully with Site Id {}",
			    buildingDTO.getBuildingName(),
			    buildingDTO.getSiteId()
			);

	}
    
    public void updateBuilding(BuildingDTO buildingDTO)
    {
    	BuildingDTO building = buildingDAO.getBuildingById(buildingDTO.getId());
    	if(building == null) 
		{
			throw new ResourceNotFoundException("Building with id " + buildingDTO.getId() + " not found");
		}
    	
    	SiteDTO site = siteDAO.getSiteById(buildingDTO.getSiteId());
    	if (site == null)
    	{
    		throw new ResourceNotFoundException("Site with id " + buildingDTO.getSiteId() + " not found");
    	}
    	
    	int rows = buildingDAO.updateBuilding(buildingDTO);
		
		if (rows == 0) 
		{
			throw new ResourceNotFoundException("Building with id " + buildingDTO.getId() + " not found");
		}
    }
    
    public void deleteBuilding(int id)
    {
    	BuildingDTO building = buildingDAO.getBuildingById(id);
    	if(building == null) 
		{
			throw new ResourceNotFoundException("Building with id " + id + " not found");
		}
    	
    	int rows = buildingDAO.deleteBuilding(id);
    	
    	if(rows == 0) 
    	{
    		throw new ResourceNotFoundException("Building with id " + id + " not found");
    	}
    }
	
}

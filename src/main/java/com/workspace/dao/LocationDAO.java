package com.workspace.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.workspace.dto.LocationDTO;
import com.workspace.mapper.LocationMapper;

@Repository
public class LocationDAO 
{
	private final LocationMapper locationMapper;
	
	public LocationDAO(LocationMapper locationMapper)
	{
		this.locationMapper = locationMapper ; 
	}
	
    public List<LocationDTO> getAllLocations()
    {
         return locationMapper.getAllLocations();
    }
    
    public LocationDTO getLocationById(int id)
	{
		
		return locationMapper.getLocationById(id);
	}
    
    public void addLocation(LocationDTO locationDTO)
    {
    	locationMapper.addLocation(locationDTO);
    }
    
    public int updateLocation(LocationDTO locationDTO)
    {
    	return locationMapper.updateLocation(locationDTO);
    }
    
    public int deleteLocation(int id)
    {
    	return locationMapper.deleteLocation(id);
    }
}

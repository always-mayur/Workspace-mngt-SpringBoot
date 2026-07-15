package com.workspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.workspace.dao.LocationDAO;
import com.workspace.dto.LocationDTO;
import com.workspace.exception.ResourceNotFoundException;

@Service
public class LocationService 
{
	
	private final LocationDAO locationDAO;
	
	public LocationService(LocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}

	public List<LocationDTO> getAllLocations()
	{
		return locationDAO.getAllLocations();
		
	}
	
	public LocationDTO getLocationById(int id)
	{
	    LocationDTO location = locationDAO.getLocationById(id);
	    
	    if(location == null)
	    {
	    	throw new ResourceNotFoundException("location with id"+" "+id+" "+"not found");
	    }
	    
	    return location;
		
	}
	
	public void addLocation(LocationDTO locationDTO)
	{
		locationDAO.addLocation(locationDTO);
	}
	
	public void updateLocation(LocationDTO locationDTO)
	{
		int rows = locationDAO.updateLocation(locationDTO);
		
		if (rows == 0)
		{
			throw new ResourceNotFoundException("location with id"+" "+locationDTO.getId()+" "+"not found");
		}
	}
	
	public void deleteLocation(int id)
	{
		int rows = locationDAO.deleteLocation(id);
		
		if (rows == 0)
		{
			throw new ResourceNotFoundException("location with id"+" "+id+" "+"not found");
		}
	}
}

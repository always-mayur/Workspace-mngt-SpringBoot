package com.workspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.common.CommonResponse;
import com.workspace.constants.URIConstants;
import com.workspace.dto.LocationDTO;
import com.workspace.dto.SiteDTO;
import com.workspace.service.LocationService;

import jakarta.validation.Valid;

@RestController
public class LocationController 
{
	private final LocationService locationService;

    public LocationController(LocationService locationService)
    {
        this.locationService = locationService;
    }

	@GetMapping(URIConstants.LOCATIONS)
	public CommonResponse getLocations()
	{
		CommonResponse response = new CommonResponse();
		
		response.setStatus("success");
		response.setResponseObject(locationService.getAllLocations());
		//response.setErrorMessage(null);
		
		return response;
		
	}
	
	@GetMapping(URIConstants.LOCATION_BY_ID)
	public CommonResponse getLocationById(@PathVariable int id)
	{
		CommonResponse response = new CommonResponse();
		
		response.setStatus("success");
		response.setResponseObject(locationService.getLocationById(id));
		//response.setErrorMessage(null);
		
		return response;
		
	}
	
	@PostMapping(URIConstants.LOCATIONS)
	public CommonResponse addLocation(@Valid @RequestBody LocationDTO locationDTO)
	{
		CommonResponse response = new CommonResponse();
		
		locationService.addLocation(locationDTO);
		response.setStatus("success");
		response.setResponseObject(locationDTO);
		
		return response;
	}
	
	@PutMapping(URIConstants.LOCATION_BY_ID)
	public CommonResponse updateLocation(@Valid @PathVariable int id,@RequestBody LocationDTO locationDTO)
	{
		CommonResponse response = new CommonResponse();
		
		locationDTO.setId(id);
		locationService.updateLocation(locationDTO);
		response.setStatus("success");
		response.setResponseObject(locationDTO);
		
		return response;
	}
	
	@DeleteMapping(URIConstants.LOCATION_BY_ID)
	public CommonResponse deleteLocation(@PathVariable int id )
	{
		CommonResponse response = new CommonResponse();
		
		locationService.deleteLocation(id);
		response.setStatus("success");
	    response.setResponseObject("location with id"+" "+id+" "+"deleted successfully");
		
	    return response;
	}
}

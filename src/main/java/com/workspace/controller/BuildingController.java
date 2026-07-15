package com.workspace.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;


import com.workspace.common.CommonResponse;
import com.workspace.service.BuildingService;

import jakarta.validation.Valid;

import com.workspace.constants.URIConstants;
import com.workspace.dto.BuildingDTO;

@RestController
public class BuildingController 
{
	
	private final BuildingService buildingService;
	
	public BuildingController(BuildingService buildingService)
	{
		this.buildingService = buildingService;
	}

	@GetMapping(URIConstants.BUILDINGS)
	public CommonResponse getAllBuildings(@RequestParam(defaultValue= "0") @Min(0) int page,
			@RequestParam(defaultValue ="10") @Positive int size,@RequestParam(required = false) String search,
			@RequestParam(required = false) Integer siteId, @RequestParam(required = false) Integer locationId,
			@RequestParam(required = false) String sort)
	{
		return CommonResponse.success(buildingService.getAllBuildings(
				page,size,search,siteId,locationId,sort));
	}
	
	@GetMapping(URIConstants.BUILDING_BY_ID)
	public CommonResponse getBuildingById(@PathVariable int id)
	{
		return CommonResponse.success(buildingService.getBuildingById(id));
	}
	
	@PostMapping(URIConstants.BUILDINGS)
	public CommonResponse addBuilding(@Valid @RequestBody BuildingDTO buildingDTO)
	{
		buildingService.addBuilding(buildingDTO);
		return CommonResponse.success(buildingDTO);
	}
	
	@PutMapping(URIConstants.BUILDING_BY_ID)
	public CommonResponse updateBuilding(@PathVariable int id, @Valid @RequestBody BuildingDTO buildingDTO)
	{
		buildingDTO.setId(id);
		buildingService.updateBuilding(buildingDTO);
		return CommonResponse.success(buildingDTO);
	}
	
	@DeleteMapping(URIConstants.BUILDING_BY_ID)
	public CommonResponse deleteBuilding(@PathVariable int id)
	{
		buildingService.deleteBuilding(id);
		return CommonResponse.success("Building with id " + id + " deleted successfully");
	}
}

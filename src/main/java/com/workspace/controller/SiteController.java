package com.workspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.dto.SiteDTO;
import com.workspace.service.SiteService;

import jakarta.validation.Valid;

import com.workspace.common.CommonResponse;
import com.workspace.constants.URIConstants;

@RestController
public class SiteController 
{
	private final SiteService siteService;
	
	public SiteController(SiteService siteService)
	{
		this.siteService = siteService;
	}
	
	@GetMapping(URIConstants.SITES)
	public CommonResponse getAllSites()
	{
		CommonResponse response = new CommonResponse();
		response.setStatus("success");
		response.setResponseObject(siteService.getAllSites());
		
		return response;
	}
	
	@GetMapping(URIConstants.SITE_BY_ID)
	public CommonResponse getSiteById(@PathVariable int id)
	{
		CommonResponse response = new CommonResponse();
		response.setStatus("success");
		response.setResponseObject(siteService.getSiteById(id));
		
		return response;
	}
	
    @PostMapping(URIConstants.SITES)
    public CommonResponse addSite(@Valid @RequestBody SiteDTO siteDTO)
	{
		CommonResponse response = new CommonResponse();
		
		siteService.addSite(siteDTO);
		response.setStatus("success");
		response.setResponseObject(siteDTO);
		
		return response;	
	}
    
    @PutMapping(URIConstants.SITE_BY_ID)
    public CommonResponse updateSite(@PathVariable int id, @Valid @RequestBody SiteDTO siteDTO)
	{
		CommonResponse response = new CommonResponse();
		
		siteDTO.setId(id);
		siteService.updateSite(siteDTO);
		
		response.setStatus("success");
		response.setResponseObject(siteDTO);
		
		return response;
	}
    
    @DeleteMapping(URIConstants.SITE_BY_ID)
    public CommonResponse deleteSite(@PathVariable int id)
    {
    	CommonResponse response = new CommonResponse();
		
		siteService.deleteSite(id);
		
		response.setStatus("success");
		response.setResponseObject("Site with id " + id + " deleted successfully");
		
		return response;
    }
  }

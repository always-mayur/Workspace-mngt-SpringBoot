package com.workspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workspace.dao.SiteDAO;
import com.workspace.dto.SiteDTO;
import com.workspace.exception.ResourceNotFoundException;

@Service
public class SiteService 
{
	private final SiteDAO siteDAO;
	
	public SiteService(SiteDAO siteDAO)
	{
		this.siteDAO = siteDAO;
	}
	
	public List<SiteDTO> getAllSites()
	{
		return siteDAO.getAllSites();
	}
	
	public SiteDTO getSiteById(int id)
	{
		SiteDTO site = siteDAO.getSiteById(id);
		
		if (site == null)
		{
			throw new ResourceNotFoundException("Site with id " + id + " not found");
		}
		
		return site;
	}
	
	public void addSite(SiteDTO siteDTO)
	{
		siteDAO.addSite(siteDTO);
	}
	
	public void updateSite(SiteDTO siteDTO)
	{
		int site = 	siteDAO.updateSite(siteDTO);;
		
		if (site == 0)
		{
			throw new ResourceNotFoundException("Site with id " + siteDTO.getId() + " not found");
		}
		
	}
	
	public void deleteSite(int id)
	{
		int site = siteDAO.deleteSite(id);
		
		if (site == 0)
		{
			throw new ResourceNotFoundException("Site with id " + id + " not found");
		}
		
	}
}

package com.workspace.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.workspace.dto.SiteDTO;
import com.workspace.mapper.SiteMapper;

@Repository
public class SiteDAO 
{
  private final SiteMapper siteMapper;
  
  public SiteDAO(SiteMapper siteMapper)
  {
	   this.siteMapper = siteMapper ;
  }
  
  public List<SiteDTO> getAllSites()
  {
	   return siteMapper.getAllSites();
  }
  
  public SiteDTO getSiteById(int id)
  {
  	 return siteMapper.getSiteById(id);
  }
  
  public void addSite(SiteDTO siteDTO)
  {
	  siteMapper.addSite(siteDTO);
  }
  
  public int updateSite(SiteDTO siteDTO)
  {
	  return siteMapper.updateSite(siteDTO);
  }
  
  public int deleteSite(int id)
  {
	  return siteMapper.deleteSite(id);
  }
}



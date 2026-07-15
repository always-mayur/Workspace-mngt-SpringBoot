package com.workspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.workspace.dto.SiteDTO;

@Mapper
public interface SiteMapper 
{
   List<SiteDTO> getAllSites();
   
   SiteDTO getSiteById(int id);
   
   void addSite(SiteDTO siteDTO);
   
   int updateSite(SiteDTO siteDTO);
   
   int deleteSite(int id);
}

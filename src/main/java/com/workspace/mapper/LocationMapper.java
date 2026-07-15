package com.workspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.workspace.dto.LocationDTO;

@Mapper
public interface LocationMapper 
{
  List<LocationDTO> getAllLocations();
  
  LocationDTO getLocationById(int id);
  
  void addLocation(LocationDTO locationDTO);
  
  int updateLocation(LocationDTO locationDTO);
  
  int deleteLocation(int id);
}


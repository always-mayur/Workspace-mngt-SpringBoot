package com.workspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LocationDTO 
{
	private int id;
	
	@NotBlank(message = "Location Name is required")
	@Size(min = 3, max = 50)
	private String locationName;
	
	@NotBlank(message = "Country is required")
	private String country;
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getLocationName() 
	{
		return locationName;
	}

	public void setLocationName(String locationName) 
	{
		this.locationName = locationName;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public LocationDTO()
	{
		
	}
	
	public LocationDTO(int id, String locationName, String country) 
	{
		this.id = id;
		this.locationName = locationName;
		this.country = country;
	}
	
//	@Override
//	public String toString()
//	{
//	    return "LocationDTO [id=" + id +
//	            ", locationName=" + locationName +
//	            ", country=" + country + "]";
//	}
}

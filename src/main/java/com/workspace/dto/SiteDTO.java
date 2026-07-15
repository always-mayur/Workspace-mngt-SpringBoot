package com.workspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SiteDTO 
{
	private int id;
	
	@NotBlank(message = "Site name cannot be blank")
	@Size(max = 100, message = "Site name cannot exceed 100 characters")
    private String siteName;
    
    @Positive(message = "Location ID must be a positive integer")
    private int locationId;
    
    private String locationName;
    
    public SiteDTO() 
	{
	}
    
    public SiteDTO(int id, String siteName, int locationId) 
	{
		this.id = id;
		this.siteName = siteName;
		this.locationId = locationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
    
}

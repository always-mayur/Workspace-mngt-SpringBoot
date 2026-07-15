package com.workspace.dto;

public class BuildingDTO 
{
	private int id;

	private String buildingName;

	private int siteId;

	private String siteName;

	private int locationId;

	private String locationName;
	
	public BuildingDTO() 
	{
		
	}
	
	public BuildingDTO(int id, String buildingName, int siteId, String siteName, int locationId, String locationName) 
	{
		this.id = id;
		this.buildingName = buildingName;
		this.siteId = siteId;
		this.siteName = siteName;
		this.locationId = locationId;
		this.locationName = locationName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
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

package com.test.resource;

public enum ResourcesEnum {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	UpdatePlaceAPI("/maps/api/place/update/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json");
	
	private String resource;
	
	ResourcesEnum(String resource){
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
	
}

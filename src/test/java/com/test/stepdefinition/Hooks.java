package com.test.stepdefinition;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@GetPlace")
	public void beforeGetPlace() throws Throwable {
		PlaceAPIStepDefinition p = new PlaceAPIStepDefinition();
		if(PlaceAPIStepDefinition.place_id == null) {
			
			p.givenAddValidPayLoad("Sun Rise", "English", "Omega street");
			p.whenHitApi("AddPlaceAPI", "POST");
			p.thenGetPlaceResponce(200);
			p.deserializResponse("Add place");
			PlaceAPIStepDefinition.place_id = p.addplace_res_obj.getPlace_id();
		}
		
	}

}

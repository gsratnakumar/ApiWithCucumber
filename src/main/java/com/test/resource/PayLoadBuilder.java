package com.test.resource;

import java.util.ArrayList;



import com.test.pojo.AddPlacePojo;
import com.test.pojo.AddLocationPojo;
import com.test.pojo.UpdatePlacePojo;
import com.test.utils.BaseTestStepDefinition;

public class PayLoadBuilder extends BaseTestStepDefinition{

	public static AddPlacePojo getAddPlacePayLoad(String  name,String language,String address) {
		AddPlacePojo ap = new AddPlacePojo();
		ap.setAccuracy(100);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3987");
		ap.setAddress(address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);

		ArrayList<String> types = new ArrayList<String>();
		types.add("Hive park");
		types.add("Shop");
		types.add("Restrent");
		ap.setTypes(types);

		AddLocationPojo l = new AddLocationPojo();
		l.setLat(-38.383700);
		l.setLng(33.427896);
		ap.setLocation(l);
		
		return ap;
	}
	
	public static UpdatePlacePojo getUpdatePlacePayLoad(String place_id) {
		UpdatePlacePojo upp = new UpdatePlacePojo();
		upp.setPlace_id(place_id);
		upp.setKey(getBaseProperties("key"));
		upp.setAddress("Moon walk");
		
		AddLocationPojo l = new AddLocationPojo();
		l.setLat(-38.383777);
		l.setLng(33.4277865);
		
		upp.setLocation(l);
		
		
		return upp;
	}
	
	
	public static String getDeletePlacePayLoad(String place_id) {
		return "{\r\n" + 
				"    \"place_id\":\""+place_id+"\"\r\n" + 
				"}";
	}
}

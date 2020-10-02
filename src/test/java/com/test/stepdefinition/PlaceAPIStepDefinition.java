package com.test.stepdefinition;

import static org.junit.Assert.assertEquals;

import org.codehaus.groovy.ast.tools.GeneralUtils;
import org.junit.runner.RunWith;

import com.test.pojo.AddPlaceReponsePojo;
import com.test.pojo.GetPlaceResponsePojo;
import com.test.resource.PayLoadBuilder;
import com.test.resource.ResourcesEnum;
import com.test.utils.BaseTestStepDefinition;
import com.test.utils.GenaricUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

@RunWith(Cucumber.class)
public class PlaceAPIStepDefinition extends BaseTestStepDefinition {

	Response response = null;
    RequestSpecification add_req = null;
    JsonPath add_place_json = null; 
   
    AddPlaceReponsePojo addplace_res_obj = null;
    GetPlaceResponsePojo getplace_res_obj = null;
    String update_place_res = null;
    String delete_place_res = null;
 
    static String place_id = null;
    
	
    @Given("^Add place with valid payload \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and query parameters$")
    public void givenAddValidPayLoad(String name,String language,String address) {

    	add_req = given().spec(getBaseRequest()).body(PayLoadBuilder.getAddPlacePayLoad(name,language,address)); 
    }

    @When("^hit \"([^\"]*)\" resource with http request \"([^\"]*)\"$")
	public void whenHitApi(String resource,String httpmethod) throws Throwable {
		ResourcesEnum re = ResourcesEnum.valueOf(resource);
		String api = re.getResource();
		if(httpmethod.equalsIgnoreCase("POST"))
		  response = add_req.when().post(api);
		else if(httpmethod.equalsIgnoreCase("GET"))
			 response = add_req.when().get(api);
		else if(httpmethod.equalsIgnoreCase("DELETE"))
			response = add_req.when().delete(api);
		else if(httpmethod.equalsIgnoreCase("PUT"))
			response = add_req.when().put(api);
      }

    @Then("^Verify status code \"([^\"]*)\" and get response$")
	public void thenGetPlaceResponce(int statuscode) throws Throwable {
	     response = response.then().spec(getBaseResponse(statuscode)).extract().response();     
	}
	
    @And("^Deserializ the \"([^\"]*)\" response$")
    public void deserializResponse(String resoucrse_response) throws Throwable {
        if(resoucrse_response.equalsIgnoreCase("Add place")) {
           addplace_res_obj = response.as(AddPlaceReponsePojo.class); 
        }else if(resoucrse_response.equalsIgnoreCase("Get place")) {
           getplace_res_obj = response.as(GetPlaceResponsePojo.class);
        }else if(resoucrse_response.equalsIgnoreCase("Update place")) {
        	update_place_res = GenaricUtils.getValueFromJson(response, "msg");
        }else if(resoucrse_response.equalsIgnoreCase("Delete place")) {
        	delete_place_res = GenaricUtils.getValueFromJson(response, "status");
        }
    }
	
  
    public void verifyResponse(String resoucrse_response,String key) throws Throwable {
    	 deserializResponse(resoucrse_response);
    	 if(resoucrse_response.equalsIgnoreCase("Add place")) {
              
         }else if(resoucrse_response.equalsIgnoreCase("Get place")) {
            
         }else if(resoucrse_response.equalsIgnoreCase("Update place")) {
         	
         }else if(resoucrse_response.equalsIgnoreCase("Delete place")) {
         	
         }
    }
    
    @Given("^Place id with query parameters$")
    public void place_id_with_query_parameters() throws Throwable {
    	add_req = given().spec(getBaseRequest()).queryParam("place_id", place_id);
    }
    
	@Then("^Verify place name \"([^\"]*)\" using  \"([^\"]*)\" api with \"([^\"]*)\" http request$")
	public void verifyPlaceName(String expected_name ,String resource,String method) throws Throwable {
	 place_id = addplace_res_obj.getPlace_id();
	 add_req = given().spec(getBaseRequest()).queryParam("place_id", place_id);
	 whenHitApi(resource,method);
	 Response res = response.then().spec(getBaseResponse(200)).extract().response();
	 String actual_name = GenaricUtils.getValueFromJson(res, "name");
	 assertEquals(expected_name, actual_name);
	
	}

	

}

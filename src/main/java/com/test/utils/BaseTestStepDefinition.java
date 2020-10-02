package com.test.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class BaseTestStepDefinition {
	
	private static PrintStream ps = null;
	private static FileOutputStream fi = null;
	private static  Properties baseproperties = new Properties();;
	private static String ROOT_PATH = System.getProperty("user.dir");	
	private File file = new  File(ROOT_PATH+"/src/main/java/com/test/properties/baseproperties.properties");
	
	public BaseTestStepDefinition() {
		try {
			fi = new FileOutputStream("log.txt",true); 
			ps = new PrintStream(fi);
			System.out.println("Load Log file");
			try {
				baseproperties.load(new FileInputStream(file));
				System.out.println("Load properties file");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RequestSpecification getBaseRequest() {
		RequestSpecification req1 = new RequestSpecBuilder().
				                   addFilter(RequestLoggingFilter.logRequestTo(ps)).
				                   addFilter(ResponseLoggingFilter.logResponseTo(ps)).
				                   setBaseUri(baseproperties.getProperty("baseuri")).
				                   addQueryParam("key", "qaclick123").
				                   addHeader("Content-Type", "application/json").build();
	    //return req = given().spec(req1);
		return req1;
	}
	
	public ResponseSpecification getBaseResponse(int statuscode) {
		ResponseSpecification res = new ResponseSpecBuilder().
				  expectStatusCode(statuscode).
				  expectContentType("application/json").build();
				 
	    return res;		 		                                            
	}
	
	public static String getBaseProperties(String key) {
		return baseproperties.getProperty(key);
	}

}

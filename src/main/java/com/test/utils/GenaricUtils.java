package com.test.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GenaricUtils {
	
	public static String getValueFromJson(Response response,String key) {
		String res = response.asString();
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		return js.get(key).toString().trim();
	}

}

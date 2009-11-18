package com.commons.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestClientSample {

	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(new HttpMessageConverter[]{new JsonHttpMessageConverter()});

		JSONObject result = restTemplate.getForObject("http://quatsch232.appspot.com/rest/users/.js", JSONObject.class);

		JSONArray aresult = result.getJSONArray("payload");
		for (int x=0; x<aresult.length(); ++x) {
			JSONObject currResult = (JSONObject) aresult.get(x);
			System.out.format("%-100s | %s%n", currResult.get("name"), currResult.get("lastLoggedInAt"));
		}

	}


}

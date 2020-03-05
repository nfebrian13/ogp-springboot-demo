package bni.ogp.integration.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import bni.ogp.integration.enumer.Environment;
import bni.ogp.integration.enumer.JwtConstant;

@Component
public class ApiTransaction {

	public String getToken() {

		String result = null;
		ResponseEntity<String> response = null;
		RestTemplate rest = new RestTemplate();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("content-type", "application/x-www-form-urlencoded");
			headers.add("Authorization", "Basic " + Environment.AUTH.getUrl());

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("grant_type", "client_credentials");

			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

			response = rest.exchange(Environment.BNI.getUrl(), HttpMethod.POST, entity, String.class);

			JSONObject resultToken = new JSONObject(response.getBody().toString());
			result = (String) resultToken.get("access_token");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	public String getBalance(String access_token, String signature) {
		String result = null;
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String url = Environment.DEV.getUrl() + Environment.GET_BALANCE.getUrl() + "?access_token=" + access_token;

		System.out.println("signature " + signature);
		System.out.println();
		
		try {
			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");
			
			JSONObject request = new JSONObject();
            request.put("clientId", "IDBNIU0FOREJPWA==");
            request.put("accountNo", "0115476117");
            request.put("signature", signature);

            HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
            
            System.out.println(headers.toString());
            System.out.println();
            System.out.println("body " + entity.getBody());
            System.out.println();
            System.out.println("url " + url);
            
            response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            System.out.println("=======================");
            System.out.println(response.getBody().toString());
//			JSONObject resultToken = new JSONObject(response.getBody().toString());
//			result = (String) resultToken.get("customerName");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}

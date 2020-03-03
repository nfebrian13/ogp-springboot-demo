package ogp.springboot.demo.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import ogp.springboot.demo.enumer.Environment;
import ogp.springboot.demo.enumer.JwtConstant;

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
		String url = Environment.DEV.getUrl() + Environment.GET_BALANCE.getUrl() + "?" + access_token;

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

//			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			Map<String, String> map = new HashMap<String, String>();
			map.put("clientId", "IDBNIU0FOREJPWA==");
			map.put("accountNo", "0115476117");
			map.put("signature", signature);

//			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,headers);
			HttpEntity<?> request = new HttpEntity<>(map, headers);
			
			response = restTemplate.postForEntity(url, request, String.class);

			JSONObject resultToken = new JSONObject(response.getBody().toString());
			result = (String) resultToken.get("customerName");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

}

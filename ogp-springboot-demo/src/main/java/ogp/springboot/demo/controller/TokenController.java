package ogp.springboot.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ogp.springboot.demo.enumer.Environment;
import ogp.springboot.demo.util.ApiTransaction;
import ogp.springboot.demo.util.Util;

@RestController
@RequestMapping("/oauth")
public class TokenController {

	@Autowired
	private Util util;

	@Autowired
	private ApiTransaction apiTransaction;
	
	@RequestMapping(value = "/token")
	public HashMap oauthTokens() throws NoSuchAlgorithmException {

		ResponseEntity<HashMap> response = null;
		HashMap resp = null;
		RestTemplate rest = new RestTemplate();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("content-type", "application/x-www-form-urlencoded");
			headers.add("Authorization", "Basic " + Environment.AUTH.getUrl());

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("grant_type", "client_credentials");

			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

			response = rest.exchange(Environment.BNI.getUrl(), HttpMethod.POST, entity, HashMap.class);
			resp = response.getBody();

			System.out.println(resp.toString());

		} catch (Exception e) {
			HashMap hashmap = new HashMap();
			hashmap.put("errorMsg", e.getMessage());

		}

		return resp;
	}

	@RequestMapping(value = "/get/token")
	public String getTokens() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getToken();
		System.out.println("controller access_token " + result);
		System.out.println(util.generateJWTToken());

		return result;
	}
	
	@RequestMapping(value = "/get/balance")
	public String getBalance() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getBalance(apiTransaction.getToken(), util.generateJWTToken());

		System.out.println("customerName is " + result);
		return result;
	}

}

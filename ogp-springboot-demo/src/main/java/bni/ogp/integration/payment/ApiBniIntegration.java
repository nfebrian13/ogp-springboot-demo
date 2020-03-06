package bni.ogp.integration.payment;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import bni.ogp.integration.converter.ObjectConverter;
import bni.ogp.integration.enumer.Environment;
import bni.ogp.integration.enumer.JwtConstant;
import bni.ogp.integration.model.Balance;
import bni.ogp.integration.model.HouseInquiry;
import bni.ogp.integration.util.Util;

@Component
public class ApiBniIntegration {

	@Autowired
	private ObjectConverter objConv;

	@Autowired
	private Balance balance;

	@Autowired
	private HouseInquiry houseInquiry;

	@Autowired
	private Util util;

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

	public String getBalance(String access_token) {

		String result = null;
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();

		String url = Environment.DEV.getUrl() + Environment.GET_BALANCE.getUrl() + "?access_token=" + access_token;

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("accountNo", "0115476117");
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("getBalanceResponse");
				JSONObject param = jsonObj.getJSONObject("parameters");
				String client_id = jsonObj.get("clientId").toString();

				balance = objConv.balanceConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

	public String getInHouseInquiry(String access_token) {

		String result = null;
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();

		String url = Environment.DEV.getUrl() + Environment.GET_HOUSE_INQUIRY.getUrl() + "?access_token=" + access_token;

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("accountNo", "8696000000000146"); // 0115476117
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("getInHouseInquiryResponse");
				JSONObject param = jsonObj.getJSONObject("parameters");
				String client_id = jsonObj.get("clientId").toString();

				houseInquiry = objConv.houseInquiryConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

}

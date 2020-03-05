package bni.ogp.integration.payment;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;

import bni.ogp.integration.enumer.Environment;
import bni.ogp.integration.enumer.JwtConstant;

@Component
public class ApiBniIntegration {

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

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");
			
			JSONObject request = new JSONObject();
            request.put("clientId", "IDBNIU0FOREJPWA==");
            request.put("accountNo", "0115476117");
            request.put("signature", signature);

            HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
            
            response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            HttpStatus status = response.getStatusCode();
            
            JSONObject json_src = new JSONObject(response.getBody().toString());
            JSONObject jsonObj = json_src.getJSONObject("getBalanceResponse");
            String client_id = jsonObj.get("clientId").toString();
            
            JSONObject param = jsonObj.getJSONObject("parameters");
			String responseCode = param.get("responseCode").toString();
			String responseMessage = param.get("responseMessage").toString();
			String responseTimestamp = param.get("responseTimestamp").toString();
			String customerName = param.get("customerName").toString();
			String accountCurrency = param.get("responseTimestamp").toString();
			String accountBalance = param.get("customerName").toString();
			
            System.out.println("clientId " + client_id);
            System.out.println("responseCode " + responseCode);
            System.out.println("responseMessage " + responseMessage);
            System.out.println("responseTimestamp " + responseTimestamp);
            System.out.println("customerName " + customerName);
            System.out.println("accountCurrency " + accountCurrency);
            System.out.println("accountBalance " + accountBalance);
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
}

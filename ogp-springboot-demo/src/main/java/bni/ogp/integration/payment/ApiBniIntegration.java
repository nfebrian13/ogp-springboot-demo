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
import bni.ogp.integration.model.InterBankInquiry;
import bni.ogp.integration.model.InterBankPayment;
import bni.ogp.integration.model.Payment;
import bni.ogp.integration.model.PaymentStatus;
import bni.ogp.integration.util.Util;

@Component
public class ApiBniIntegration {

	@Autowired
	private ObjectConverter objConv;

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

	public Balance getBalance(String access_token) {

		final String url = Environment.DEV.getUrl() + Environment.GET_BALANCE.getUrl() + "?access_token=" + access_token;
		
		Balance objBalance = new Balance();
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();

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
//				String client_id = jsonObj.get("clientId").toString();

				objBalance = objConv.balanceConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return objBalance;
	}

	public HouseInquiry getInHouseInquiry(String access_token) {

		final  String url = Environment.DEV.getUrl() + Environment.GET_HOUSE_INQUIRY.getUrl() + "?access_token=" + access_token;
		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		HouseInquiry objHouseInquiry = new HouseInquiry();

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
//				String client_id = jsonObj.get("clientId").toString();

				objHouseInquiry = objConv.houseInquiryConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return objHouseInquiry;
	}

	public PaymentStatus getPaymentStatus(String access_token) {

		final String url = Environment.DEV.getUrl() + Environment.GET_PAYMENT_STATUS.getUrl() + "?access_token=" + access_token;
		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		PaymentStatus objPayment = new PaymentStatus();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("customerReferenceNumber", "20170227000000000020");
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("getPaymentStatusResponse");
				JSONObject param = jsonObj.getJSONObject("parameters");
//				String client_id = jsonObj.get("clientId").toString();

				objPayment = objConv.PaymentStatusConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return objPayment;
		
	}

	public InterBankInquiry getInterBankInquiry(String access_token) {

		final String url = Environment.DEV.getUrl() + Environment.GET_INTERBANK_INQUIRY.getUrl() + "?access_token=" + access_token;
		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		InterBankInquiry objInterBank = new InterBankInquiry();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("accountNum", "113183203");
			request.put("destinationBankCode", "014");
			request.put("destinationAccountNum", "3333333333");
			request.put("customerReferenceNumber", "20170227000000000021");
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("getInterbankInquiryResponse");
				JSONObject param = jsonObj.getJSONObject("parameters");
//				String client_id = jsonObj.get("clientId").toString();

				objInterBank = objConv.interBankInquiryConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return objInterBank;
	}

	public InterBankPayment getInterBankPayment(String access_token) {

		final String url = Environment.DEV.getUrl() + Environment.GET_INTERBANK_PAYMENT.getUrl() + "?access_token=" + access_token;
		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		InterBankPayment objInterBankPayment = new InterBankPayment();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("customerReferenceNumber", "20170227000000000021");
			request.put("amount", "10000");
			request.put("destinationAccountNum", "3333333333");
			request.put("destinationAccountName", "BENEFICIARY NAME 1 UNTIL HERE1BENEFICIARY NAME 2(OPT) UNTIL HERE2");
			request.put("destinationBankCode", "014");
			request.put("destinationBankName", "BCA");
			request.put("accountNum", "115471119");
			request.put("retrievalReffNum", "100000000024");
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("getInterbankPaymentResponse");
				JSONObject param = jsonObj.getJSONObject("parameters");
//				String client_id = jsonObj.get("clientId").toString();

				objInterBankPayment = objConv.interBankPaymentConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return objInterBankPayment;
	}
	
	public Payment doPayment(String access_token) {

		final String url = Environment.DEV.getUrl() + Environment.DO_PAYMENT.getUrl() + "?access_token=" + access_token;
		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		Payment objPayment = new Payment();

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("x-api-key", JwtConstant.API_KEY.getValue());
			headers.add("Content-Type", "application/json");

			JSONObject request = new JSONObject();
			request.put("clientId", "IDBNIU0FOREJPWA==");
			request.put("customerReferenceNumber", "20170227000000000020");
			request.put("paymentMethod", "0");
			request.put("debitAccountNo", "113183203");
			request.put("creditAccountNo", "115471119");
			request.put("valueDate", "20170227000000000");
			request.put("valueCurrency", "IDR");
			request.put("valueAmount", "100500");
			request.put("remark", "?");
			request.put("beneficiaryEmailAddress", "");
			request.put("beneficiaryName", "Mr.X");
			request.put("beneficiaryAddress1", "Jakarta");
			request.put("beneficiaryAddress2", "");
			request.put("destinationBankCode", "CENAIDJAXXX");
			request.put("chargingModelId", "OUR");
			request.put("signature", util.generateJWTToken(request.toString()));

			HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			HttpStatus statusCode = response.getStatusCode();

			if (statusCode != null && statusCode.is2xxSuccessful()) {

				JSONObject jsonSrc = new JSONObject(response.getBody().toString());
				JSONObject jsonObj = jsonSrc.getJSONObject("doPaymentResponse"); 
				JSONObject param = jsonObj.getJSONObject("parameters");
//				String client_id = jsonObj.get("clientId").toString();

				objPayment = objConv.paymentConverter(param);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return objPayment;
	}
	

}

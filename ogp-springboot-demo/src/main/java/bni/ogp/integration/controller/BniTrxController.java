package bni.ogp.integration.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bni.ogp.integration.payment.ApiBniIntegration;
import bni.ogp.integration.util.Util;

@RestController
@RequestMapping("/trx")
public class BniTrxController {

	@Autowired
	private Util util;

	@Autowired
	private ApiBniIntegration apiTransaction;

	@RequestMapping(value = "/get/balance")
	public String getBalance() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getBalance(apiTransaction.getToken());

		return result;
	}
	
	@RequestMapping(value = "/get/inHouseInquiry")
	public String getInHouseInquiry() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getInHouseInquiry(apiTransaction.getToken());

		return result;
	}
	
	@RequestMapping(value = "/get/paymentStatus")
	public String getPaymentStatus() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getPaymentStatus(apiTransaction.getToken());

		return result;
	}
	
	@RequestMapping(value = "/get/InterBankInquiry")
	public String getInterBankInquiry() throws NoSuchAlgorithmException {

		String result = null;
		result = apiTransaction.getInterBankInquiry(apiTransaction.getToken());

		return result;
	}
	
	

}

package bni.ogp.integration.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bni.ogp.integration.model.Balance;
import bni.ogp.integration.model.HouseInquiry;
import bni.ogp.integration.model.InterBankInquiry;
import bni.ogp.integration.model.InterBankPayment;
import bni.ogp.integration.model.PaymentStatus;
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
		Balance bal = new Balance();
		bal = apiTransaction.getBalance(apiTransaction.getToken());
		return bal.getCustomerName();
	}

	@RequestMapping(value = "/get/inHouseInquiry")
	public String getInHouseInquiry() throws NoSuchAlgorithmException {
		HouseInquiry objHouseInquiry = new HouseInquiry();
		objHouseInquiry = apiTransaction.getInHouseInquiry(apiTransaction.getToken());
		return objHouseInquiry.getCustomerName();
	}

	@RequestMapping(value = "/get/paymentStatus")
	public String getPaymentStatus() throws NoSuchAlgorithmException {
		PaymentStatus objPaymentStatus = new PaymentStatus();
		objPaymentStatus = apiTransaction.getPaymentStatus(apiTransaction.getToken());
		return objPaymentStatus.getCustomerReference();
	}

	@RequestMapping(value = "/get/interBankInquiry")
	public String getInterBankInquiry() throws NoSuchAlgorithmException {
		InterBankInquiry objInterBankInquiry = new InterBankInquiry();
		objInterBankInquiry = apiTransaction.getInterBankInquiry(apiTransaction.getToken());
		return objInterBankInquiry.getDestinationBankName();
	}

	@RequestMapping(value = "/get/interBankPayment")
	public String getInterBankPayment() throws NoSuchAlgorithmException {
		InterBankPayment objInterBankPayment = new InterBankPayment();
		objInterBankPayment = apiTransaction.getInterBankPayment(apiTransaction.getToken());
		return objInterBankPayment.getAccountName();
	}

}

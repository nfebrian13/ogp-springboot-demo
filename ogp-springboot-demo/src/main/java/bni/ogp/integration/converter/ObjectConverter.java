package bni.ogp.integration.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bni.ogp.integration.model.Balance;
import bni.ogp.integration.model.HoldAmount;
import bni.ogp.integration.model.HoldAmountRelease;
import bni.ogp.integration.model.HouseInquiry;
import bni.ogp.integration.model.InterBankInquiry;
import bni.ogp.integration.model.InterBankPayment;
import bni.ogp.integration.model.Payment;
import bni.ogp.integration.model.PaymentStatus;

@Component
public class ObjectConverter {

	@Autowired
	private Balance balance;

	@Autowired
	private HoldAmount holdAmount;

	@Autowired
	private HoldAmountRelease holdAmountRelease;

	@Autowired
	private HouseInquiry houseInquiry;

	@Autowired
	private InterBankInquiry interBankInquiry;

	@Autowired
	private InterBankPayment interBankPayment;
	
	@Autowired
	private Payment payment;
	
	@Autowired
	private PaymentStatus paymentStatus;

	public Balance balanceConverter(JSONObject jsonObj) throws JSONException {
		return balance;
	}

	public HoldAmount holdAmountConverter(JSONObject jsonObj) throws JSONException {
		return holdAmount;
	}

	public HoldAmountRelease holdAmountReleaseConverter(JSONObject jsonObj) throws JSONException {
		return holdAmountRelease;
	}

	public HouseInquiry houseInquiryConverter(JSONObject jsonObj) throws JSONException {
		return houseInquiry;
	}

	public InterBankPayment interBankPaymentConverter(JSONObject jsonObj) throws JSONException {
		return interBankPayment;
	}

	public InterBankInquiry interBankInquiryConverter(JSONObject jsonObj) throws JSONException {
		return interBankInquiry;
	}
	
	public Payment paymentConverter(JSONObject jsonObj) throws JSONException {
		return payment;
	}
	
	public PaymentStatus PaymentStatusConverter(JSONObject jsonObj) throws JSONException {
		return paymentStatus;
	}

}

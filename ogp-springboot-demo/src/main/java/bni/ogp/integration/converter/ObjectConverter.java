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
		balance.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		balance.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		balance.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		balance.setCustomerName(jsonObj.isNull("customerName") ? null : jsonObj.get("customerName").toString());
		balance.setAccountCurrency(jsonObj.isNull("accountCurrency") ? null : jsonObj.get("accountCurrency").toString());
		balance.setAccountBalance(jsonObj.isNull("accountBalance") ? null : jsonObj.get("accountBalance").toString());
		return balance;
	}

	public HoldAmount holdAmountConverter(JSONObject jsonObj) throws JSONException {
		holdAmount.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		holdAmount.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		holdAmount.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		holdAmount.setAccountOwner(jsonObj.isNull("accountOwner") ? null : jsonObj.get("accountOwner").toString());
		holdAmount.setBankReference(jsonObj.isNull("bankReference") ? null : jsonObj.get("bankReference").toString());
		holdAmount.setCustomerReference(jsonObj.isNull("customerReference") ? null : jsonObj.get("customerReference").toString());
		return holdAmount;
	}

	public HoldAmountRelease holdAmountReleaseConverter(JSONObject jsonObj) throws JSONException {
		holdAmountRelease.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		holdAmountRelease.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		holdAmountRelease.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		holdAmountRelease.setAccountOwner(jsonObj.isNull("accountOwner") ? null : jsonObj.get("accountOwner").toString());
		holdAmountRelease.setBankReference(jsonObj.isNull("bankReference") ? null : jsonObj.get("bankReference").toString());
		holdAmountRelease.setCustomerReference(jsonObj.isNull("customerReference") ? null : jsonObj.get("customerReference").toString());
		return holdAmountRelease;
	}

	public HouseInquiry houseInquiryConverter(JSONObject jsonObj) throws JSONException {
		houseInquiry.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		houseInquiry.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		houseInquiry.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		houseInquiry.setAccountCurrency(jsonObj.isNull("accountCurrency") ? null : jsonObj.get("accountCurrency").toString());
		houseInquiry.setAccountNumber(jsonObj.isNull("accountNumber") ? null : jsonObj.get("accountNumber").toString());
		houseInquiry.setAccountStatus(jsonObj.isNull("accountStatus") ? null : jsonObj.get("accountStatus").toString());
		houseInquiry.setAccountType(jsonObj.isNull("accountType") ? null : jsonObj.get("accountType").toString());
		return houseInquiry;
	}

	public InterBankPayment interBankPaymentConverter(JSONObject jsonObj) throws JSONException {
		interBankPayment.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		interBankPayment.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		interBankPayment.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		interBankPayment.setDestinationAccountNum(jsonObj.isNull("destinationAccountNum") ? null : jsonObj.get("destinationAccountNum").toString());
		interBankPayment.setDestinationAccountName(jsonObj.isNull("destinationAccountName") ? null : jsonObj.get("destinationAccountName").toString());
		interBankPayment.setAccountName(jsonObj.isNull("accountName") ? null : jsonObj.get("accountName").toString());
		interBankPayment.setCustomerReffNum(jsonObj.isNull("customerReffNum") ? null : jsonObj.get("customerReffNum").toString());
		return interBankPayment;
	}

	public InterBankInquiry interBankInquiryConverter(JSONObject jsonObj) throws JSONException {
		interBankInquiry.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		interBankInquiry.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		interBankInquiry.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		interBankInquiry.setDestinationAccountNum(jsonObj.isNull("destinationAccountNum") ? null : jsonObj.get("destinationAccountNum").toString());
		interBankInquiry.setDestinationAccountName(jsonObj.isNull("destinationAccountName") ? null : jsonObj.get("destinationAccountName").toString());
		interBankInquiry.setDestinationBankName(jsonObj.isNull("destinationBankName") ? null : jsonObj.get("destinationBankName").toString());
		interBankInquiry.setRetrievalReffNum(jsonObj.isNull("retrievalReffNum") ? null : jsonObj.get("retrievalReffNum").toString());
		return interBankInquiry;
	}
	
	public Payment paymentConverter(JSONObject jsonObj) throws JSONException {
		payment.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		payment.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		payment.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		payment.setDebitAccountNo(jsonObj.isNull("debitAccountNo") ? null : jsonObj.get("debitAccountNo").toString());
		payment.setCreditAccountNo(jsonObj.isNull("creditAccountNo") ? null : jsonObj.get("creditAccountNo").toString());
		payment.setValueAmount(jsonObj.isNull("valueAmount") ? null : jsonObj.get("valueAmount").toString());
		payment.setValueCurrency(jsonObj.isNull("valueCurrency") ? null : jsonObj.get("valueCurrency").toString());
		payment.setBankReference(jsonObj.isNull("bankReference") ? null : jsonObj.get("bankReference").toString());
		payment.setCustomerReference(jsonObj.isNull("customerReference") ? null : jsonObj.get("customerReference").toString());
		return payment;
	}
	
	public PaymentStatus PaymentStatusConverter(JSONObject jsonObj) throws JSONException {
		paymentStatus.setResponseCode(jsonObj.isNull("responseCode") ? null : jsonObj.get("responseCode").toString());
		paymentStatus.setResponseMessage(jsonObj.isNull("responseMessage") ? null : jsonObj.get("responseMessage").toString());
		paymentStatus.setResponseTimestamp(jsonObj.isNull("responseTimestamp") ? null : jsonObj.get("responseTimestamp").toString());
		paymentStatus.setBankReference(jsonObj.isNull("bankReference") ? null : jsonObj.get("bankReference").toString());
		paymentStatus.setCustomerReference(jsonObj.isNull("customerReference") ? null : jsonObj.get("customerReference").toString());
		return paymentStatus;
	}

}

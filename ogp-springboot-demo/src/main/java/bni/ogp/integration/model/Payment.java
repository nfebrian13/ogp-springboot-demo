package bni.ogp.integration.model;

import org.springframework.stereotype.Component;

@Component
public class Payment {

	private String responseCode;
	private String responseMessage;
	private String responseTimestamp;
	private String debitAccountNo;
	private String creditAccountNo;
	private String valueAmount;
	private String valueCurrency;
	private String bankReference;
	private String customerReference;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getResponseTimestamp() {
		return responseTimestamp;
	}
	public void setResponseTimestamp(String responseTimestamp) {
		this.responseTimestamp = responseTimestamp;
	}
	public String getDebitAccountNo() {
		return debitAccountNo;
	}
	public void setDebitAccountNo(String debitAccountNo) {
		this.debitAccountNo = debitAccountNo;
	}
	public String getCreditAccountNo() {
		return creditAccountNo;
	}
	public void setCreditAccountNo(String creditAccountNo) {
		this.creditAccountNo = creditAccountNo;
	}
	public String getValueAmount() {
		return valueAmount;
	}
	public void setValueAmount(String valueAmount) {
		this.valueAmount = valueAmount;
	}
	public String getValueCurrency() {
		return valueCurrency;
	}
	public void setValueCurrency(String valueCurrency) {
		this.valueCurrency = valueCurrency;
	}
	public String getBankReference() {
		return bankReference;
	}
	public void setBankReference(String bankReference) {
		this.bankReference = bankReference;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	
}

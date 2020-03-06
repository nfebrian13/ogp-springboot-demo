package bni.ogp.integration.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class PaymentStatus {

	private String responseCode;
	private String responseMessage;
	private String responseTimestamp;
	private String bankReference;
	private String customerReference;
	
	private PreviousResponse previousResponse;
	private String transactionStatus;
	private String previousResponseCode;
	private String previousResponseMessage;
	private String previousResponseTimestamp;
	private String debitAccountNo;
	private String creditAccountNo;
	private String valueAmount;
	private String valueCurrency;
	
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
	public PreviousResponse getPreviousResponse() {
		return previousResponse;
	}
	public void setPreviousResponse(PreviousResponse previousResponse) {
		this.previousResponse = previousResponse;
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
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getPreviousResponseCode() {
		return previousResponseCode;
	}
	public void setPreviousResponseCode(String previousResponseCode) {
		this.previousResponseCode = previousResponseCode;
	}
	public String getPreviousResponseMessage() {
		return previousResponseMessage;
	}
	public void setPreviousResponseMessage(String previousResponseMessage) {
		this.previousResponseMessage = previousResponseMessage;
	}
	public String getPreviousResponseTimestamp() {
		return previousResponseTimestamp;
	}
	public void setPreviousResponseTimestamp(String previousResponseTimestamp) {
		this.previousResponseTimestamp = previousResponseTimestamp;
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
}

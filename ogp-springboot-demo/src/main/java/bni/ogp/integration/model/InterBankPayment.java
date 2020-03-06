package bni.ogp.integration.model;

import org.springframework.stereotype.Component;

@Component
public class InterBankPayment {
	
	private String responseCode;
	private String responseMessage;
	private String responseTimestamp;
	private String destinationAccountNum;
	private String destinationAccountName;
	private String destinationBankName;
	private String accountName;
	private String customerReffNum;
	
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
	public String getDestinationAccountNum() {
		return destinationAccountNum;
	}
	public void setDestinationAccountNum(String destinationAccountNum) {
		this.destinationAccountNum = destinationAccountNum;
	}
	public String getDestinationAccountName() {
		return destinationAccountName;
	}
	public void setDestinationAccountName(String destinationAccountName) {
		this.destinationAccountName = destinationAccountName;
	}
	public String getDestinationBankName() {
		return destinationBankName;
	}
	public void setDestinationBankName(String destinationBankName) {
		this.destinationBankName = destinationBankName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCustomerReffNum() {
		return customerReffNum;
	}
	public void setCustomerReffNum(String customerReffNum) {
		this.customerReffNum = customerReffNum;
	}
}

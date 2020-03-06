package bni.ogp.integration.model;

import org.springframework.stereotype.Component;

@Component
public class PaymentStatus {

	private String responseCode;
	private String responseMessage;
	private String responseTimestamp;
	private PreviousResponse previousResponse;
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
}

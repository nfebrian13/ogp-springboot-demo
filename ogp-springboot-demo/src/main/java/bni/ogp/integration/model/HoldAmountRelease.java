package bni.ogp.integration.model;

import org.springframework.stereotype.Component;

@Component
public class HoldAmountRelease {

	private String accountOwner;
	private String customerReference;
	private String bankReference;
	
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	public String getBankReference() {
		return bankReference;
	}
	public void setBankReference(String bankReference) {
		this.bankReference = bankReference;
	}
}

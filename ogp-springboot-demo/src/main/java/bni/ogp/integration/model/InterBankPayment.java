package bni.ogp.integration.model;

import org.springframework.stereotype.Component;

@Component
public class InterBankPayment {
	
	private String destinationAccountNum;
	private String destinationAccountName;
	private String destinationBankName;
	private String accountName;
	
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
	
}

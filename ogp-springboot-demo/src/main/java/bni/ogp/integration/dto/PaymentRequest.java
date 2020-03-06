package bni.ogp.integration.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentRequest {

	private String clientId;
	private String signature;
	private String customerReferenceNumber;
	private String paymentMethod;
	private String debitAccountNo;
	private String creditAccountNo;
	private String valueDate;
	private String valueCurrency;
	private String valueAmount;
	private String remark;
	private String beneficiaryEmailAddress;
	private String beneficiaryName;
	private String beneficiaryAddress1;
	private String beneficiaryAddress2;
	private String destinationBankCode;
	private String chargingModelId;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getCustomerReferenceNumber() {
		return customerReferenceNumber;
	}
	public void setCustomerReferenceNumber(String customerReferenceNumber) {
		this.customerReferenceNumber = customerReferenceNumber;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getValueCurrency() {
		return valueCurrency;
	}
	public void setValueCurrency(String valueCurrency) {
		this.valueCurrency = valueCurrency;
	}
	public String getValueAmount() {
		return valueAmount;
	}
	public void setValueAmount(String valueAmount) {
		this.valueAmount = valueAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBeneficiaryEmailAddress() {
		return beneficiaryEmailAddress;
	}
	public void setBeneficiaryEmailAddress(String beneficiaryEmailAddress) {
		this.beneficiaryEmailAddress = beneficiaryEmailAddress;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryAddress1() {
		return beneficiaryAddress1;
	}
	public void setBeneficiaryAddress1(String beneficiaryAddress1) {
		this.beneficiaryAddress1 = beneficiaryAddress1;
	}
	public String getBeneficiaryAddress2() {
		return beneficiaryAddress2;
	}
	public void setBeneficiaryAddress2(String beneficiaryAddress2) {
		this.beneficiaryAddress2 = beneficiaryAddress2;
	}
	public String getDestinationBankCode() {
		return destinationBankCode;
	}
	public void setDestinationBankCode(String destinationBankCode) {
		this.destinationBankCode = destinationBankCode;
	}
	public String getChargingModelId() {
		return chargingModelId;
	}
	public void setChargingModelId(String chargingModelId) {
		this.chargingModelId = chargingModelId;
	}
	
}

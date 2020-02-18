package ogp.springboot.demo.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Payment {

	private String customerReferenceNumber;
	private String paymentMethod;
	private String debitAccountNo;
	private String creditAccountNo;
	private String valueDate;
	private String valueCurrency;
	private BigDecimal valueAmount;
	private String remark;
	private String beneficiaryEmailAddress;
	private String destinationBankCode;
	private String beneficiaryName;
	private String beneficiaryAddress1;
	private String beneficiaryAddress2;
	private String chargingModelId;
	private BigInteger bankReference;
	private BigInteger customerReference;
	
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
	public BigDecimal getValueAmount() {
		return valueAmount;
	}
	public void setValueAmount(BigDecimal valueAmount) {
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
	public String getDestinationBankCode() {
		return destinationBankCode;
	}
	public void setDestinationBankCode(String destinationBankCode) {
		this.destinationBankCode = destinationBankCode;
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
	public String getChargingModelId() {
		return chargingModelId;
	}
	public void setChargingModelId(String chargingModelId) {
		this.chargingModelId = chargingModelId;
	}
	public BigInteger getBankReference() {
		return bankReference;
	}
	public void setBankReference(BigInteger bankReference) {
		this.bankReference = bankReference;
	}
	public BigInteger getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(BigInteger customerReference) {
		this.customerReference = customerReference;
	}
	
	
	
}

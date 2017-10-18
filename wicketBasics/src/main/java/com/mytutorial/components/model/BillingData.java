package com.mytutorial.components.model;

import java.io.Serializable;

public class BillingData implements Serializable{
	
	private BancAccount bancAccount;
	private PersonalData accountOwnerPersonalData;
	private Address accountOwnerAddressData;
	
	
	
	public BillingData() {
		this.bancAccount=new BancAccount();
		this.accountOwnerPersonalData=new PersonalData();
		this.accountOwnerAddressData=new Address();
	}
	public BancAccount getBancAccount() {
		return bancAccount;
	}
	public void setBancAccount(BancAccount bancAccount) {
		this.bancAccount = bancAccount;
	}
	public PersonalData getAccountOwnerData() {
		return accountOwnerPersonalData;
	}
	public void setAccountOwnerData(PersonalData accountOwnerData) {
		this.accountOwnerPersonalData = accountOwnerData;
	}
	public Address getAccountOwnerAddress() {
		return accountOwnerAddressData;
	}
	public void setAccountOwnerAddress(Address accountOwnerAddress) {
		this.accountOwnerAddressData = accountOwnerAddress;
	} 

	
	
}

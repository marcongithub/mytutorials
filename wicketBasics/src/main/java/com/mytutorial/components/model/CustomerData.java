package com.mytutorial.components.model;

import java.io.Serializable;

public class CustomerData implements Serializable{
	
	private PersonalData customerPersonalData;
	private Address customerAdressData;
	
	
	
	public CustomerData() {
		this.customerPersonalData=new PersonalData();
		this.customerAdressData=new Address();
	}
	public PersonalData getCustomerPersonalData() {
		return customerPersonalData;
	}
	public void setCustomerPersonalData(PersonalData customerPersonalData) {
		this.customerPersonalData = customerPersonalData;
	}
	public Address getCustomerAdressData() {
		return customerAdressData;
	}
	public void setCustomerAdressData(Address customerAdressData) {
		this.customerAdressData = customerAdressData;
	}

}

package com.wicketTutorial.components.model;

import java.io.Serializable;
public class Order implements Serializable{
	
	private CustomerData customerData;
	private BillingData billingData;
	private CarSelection carSelection;
	
	private int version;
	
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public Order() {
		this.customerData=new CustomerData();
		this.billingData=new BillingData();
	}
	public BillingData getBillingData() {
		return billingData;
	}
	public void setBillingData(BillingData billingData) {
		this.billingData = billingData;
	}
	public CustomerData getCustomerData() {
		return customerData;
	}
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}
	public CarSelection getCarSelection() {
		return carSelection;
	}
	public void setCarSelection(CarSelection carSelection) {
		this.carSelection = carSelection;
	}

}

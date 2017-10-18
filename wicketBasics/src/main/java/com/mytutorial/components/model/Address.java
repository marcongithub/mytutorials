package com.mytutorial.components.model;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String street;
	private Integer postalCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
    public Integer getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
	
	
	

}

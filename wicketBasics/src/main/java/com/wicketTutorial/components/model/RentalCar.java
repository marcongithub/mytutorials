package com.wicketTutorial.components.model;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class RentalCar implements Serializable{
	
	private String brand;
	
	private String type;
	
	private Boolean typeRequired;
	
	public static RentalCar dummy = new RentalCar("","",false);

	public RentalCar(String brand, String type, boolean typeRequired) {
		this.brand = brand;
		this.type = type;
		this.typeRequired = typeRequired;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getTypeRequired() {
		return typeRequired;
	}

	public void setTypeRequired(Boolean typeRequired) {
		this.typeRequired = typeRequired;
	}

	public boolean isDummy(){
		return StringUtils.isEmpty(this.brand);
	}
	
	

}

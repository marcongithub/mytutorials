package com.wicketTutorial.components.model;

import java.io.Serializable;
import java.util.List;

public class CarSelection implements Serializable {

	public static final int MAX_ALTERNATIVES = 7;

	private List<RentalCar> carAlternatives;

	public List<RentalCar> getCarAlternatives() {
		return carAlternatives;
	}

	public void setCarAlternatives(List<RentalCar> carAlternatives) {
		this.carAlternatives = carAlternatives;
	}

}

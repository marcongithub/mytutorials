package com.wicketTutorial.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;

import com.wicketTutorial.components.model.CarSelection;
import com.wicketTutorial.components.model.Order;
import com.wicketTutorial.components.model.RentalCar;

public abstract class ComponentTestPage extends WebPage{
	public ComponentTestPage(IModel<?> model) {
		super(model);
//		add(CSSPackageResource.getHeaderContribution(ComponentTestPage.class,"components.css"));
	}

    public ComponentTestPage() {
        super();
//        add(CSSPackageResource.getHeaderContribution(ComponentTestPage.class,"components.css"));
    }
	
    protected Order createOrder() {
		Order order = new Order();
		CarSelection carSelection = new CarSelection();
		List<RentalCar> carAlternatives = new ArrayList<RentalCar>();
		carAlternatives.add(new RentalCar("BMW", "Diesel", true));
		carAlternatives.add(new RentalCar("Audi", "Benzin", false));
		carAlternatives.add(new RentalCar("VW", "Benzin", true));
		carAlternatives.add(new RentalCar(null, null, false));
		carSelection.setCarAlternatives(carAlternatives );
		order.setCarSelection(carSelection );
		
		return order;
	}

}

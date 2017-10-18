package com.mytutorial.components;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.mytutorial.components.model.CarSelection;
import com.mytutorial.components.model.RentalCar;

public class CarSelectionPanel extends Panel {

	private IModel<CarSelection> carSelectionModel;

	public CarSelectionPanel(String id, IModel<CarSelection> carSelectionModel) {
		super(id, carSelectionModel);
		this.carSelectionModel = carSelectionModel;
		setDefaultModel(new CompoundPropertyModel<CarSelection>(
				carSelectionModel){
			@Override
			public CarSelection getObject() {
				// TODO Auto-generated method stub
				return super.getObject();
			}
		});
	}

	@Override
	protected void onConfigure() {
		configureAlternatives(carSelectionModel);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(firstCar());
		PropertyListView<RentalCar> carAlternatives = new PropertyListView<RentalCar>(
				"carAlternatives") {
			@Override
			protected void populateItem(ListItem<RentalCar> item) {
				TextField<String> brand = new TextField<String>("brand");
				CheckBox typeRequired = new CheckBox("typeRequired");
				if (item.getIndex() == 0) {
					item.setVisible(false);
				}
				item.add(brand);
				item.add(typeRequired);
			}
		};
		carAlternatives.setReuseItems(true);
		add(carAlternatives);
	}

	private WebMarkupContainer firstCar() {
		CompoundPropertyModel<RentalCar> firstCarModel = new CompoundPropertyModel<RentalCar>(
				this.carSelectionModel.getObject().getCarAlternatives().get(0));
		WebMarkupContainer firstCar = new WebMarkupContainer("firstCar",
				firstCarModel);

		firstCar.add(new TextField<String>("brand"));
		firstCar.add(new TextField<String>("type"));
		return firstCar;
	}

	private void configureAlternatives(IModel<CarSelection> carSelectionModel) {
		List<RentalCar> alternatives = carSelectionModel.getObject()
				.getCarAlternatives();
		int itemsToAdd = (CarSelection.MAX_ALTERNATIVES - alternatives.size());
		for (int i = 0; i < itemsToAdd; i++) {
			alternatives.add(new RentalCar("", "", false));
		}
	}

}

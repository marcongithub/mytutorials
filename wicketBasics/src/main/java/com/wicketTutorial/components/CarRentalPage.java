package com.wicketTutorial.components;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

import com.wicketTutorial.components.model.CarSelection;
import com.wicketTutorial.components.model.Order;
import com.wicketTutorial.components.model.RentalCar;

public class CarRentalPage extends ComponentTestPage {

	public CarRentalPage() {
		Order order = createOrder();
		OrderModel orderModel = new OrderModel(order);
		setDefaultModel(orderModel);
	}

	public CarRentalPage(OrderModel orderModel) {
		super(orderModel);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		OrderModel orderModel = (OrderModel) this.getDefaultModel();
		Form<Order> form = new Form<Order>("myForm", orderModel) {
			@Override
			protected void onSubmit() {
				OrderModel orderModel = (OrderModel) this.getModel();
				Order order = orderModel.getObject();
				List<RentalCar> alternatives = order.getCarSelection()
						.getCarAlternatives();
				removeDummies(alternatives);
				System.out.println("+++++++++ "+alternatives.size());
			}

			private void removeDummies(List<RentalCar> alternatives) {
				Iterator<RentalCar> it = alternatives.iterator();
				while (it.hasNext()) {
					if (it.next().isDummy()) {
						it.remove();
					}
				}

			}
		};
		form.add(new Button("mySubmitButton"));
		form.add(new CarSelectionPanel("carSelectionPanel",
				new PropertyModel<CarSelection>(orderModel, "carSelection")));
		add(form);
	}

}

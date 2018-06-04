package com.wicketTutorial.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

import com.wicketTutorial.components.model.Address;
import com.wicketTutorial.components.model.Order;
import com.wicketTutorial.components.model.PersonalData;

public class CustomerDataPage extends ComponentTestPage {

	public CustomerDataPage() {
		super();
		Order order = createOrder();
		OrderModel orderModel = new OrderModel(order);

		Form<Order> form = new Form<Order>("myForm", orderModel) {

			@Override
			protected void onSubmit() {
				OrderModel orderModel = (OrderModel) this.getModel();
//				this.setResponsePage(new CarRentalPage(orderModel));

			}
		};

		// add personal data panel
		PersonalDataPanel personalDataPanel = new PersonalDataPanel("personalDataPanel",
				new PropertyModel<PersonalData>(orderModel, "customerData.customerPersonalData") {
					@Override
					public void setObject(PersonalData object) {
						super.setObject(object);
					}

					@Override
					public PersonalData getObject() {
						return super.getObject();
					}
				});
		form.add(personalDataPanel);

		// add address data panel
		AdressPanel addressPanel = new AdressPanel("adressDataPanel",
				new PropertyModel<Address>(orderModel, "customerData.customerAdressData"));
		form.add(addressPanel);

		// add buttons
		AjaxButton checkButton = new AjaxButton("checkButton", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
//				target.add(form);
//				this.setResponsePage(new CarRentalPage(orderModel));
			}
		};

		form.add(checkButton);
		Button submitButton = new Button("mySubmitButton") {
			@Override
			public void onSubmit() {
//				this.setResponsePage(new CarRentalPage(orderModel));
			}
		};
		form.add(submitButton);
		add(form);
	}

}

package com.wicketTutorial.components;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.wicketTutorial.components.model.Address;
import com.wicketTutorial.components.model.Order;
import com.wicketTutorial.components.model.PersonalData;

/**
 * Testen: hier order als member, statt orderModel, auf der nächsten Page merge simulieren (-> liefert neues Object).
 * Dann zurück auf Page.
 * 
 * 
 * @author marco
 *
 */
public class BillingDataPage extends ComponentTestPage {

    public BillingDataPage(OrderModel orderModel) {
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
                orderModel.getObject();
            }
        };

        // add personal data panel
        PersonalDataPanel personalDataPanel = new PersonalDataPanel("personalDataPanel",
                new PropertyModel<PersonalData>(orderModel, "billingData.accountOwnerPersonalData"));
        form.add(personalDataPanel);

        // add address data panel
        AdressPanel addressPanel = new AdressPanel("adressDataPanel", new PropertyModel<Address>(orderModel,
                "billingData.accountOwnerAddressData"));
        form.add(addressPanel);

        // add additional input fields
        form.add(new TextField<String>("billingData.bancAccount.accountNr", new PropertyModel<String>(orderModel,
                "billingData.bancAccount.accountNr")));
        form.add(new TextField<String>("billingData.bancAccount.bancName", new PropertyModel<String>(orderModel,
                "billingData.bancAccount.bancName")));

        Button submitButton = new Button("mySubmitButton") {
            @Override
            public void onSubmit() {
                // TODO Auto-generated method stub
                super.onSubmit();
            }
        };
        form.add(submitButton);

        add(form);
    }

}

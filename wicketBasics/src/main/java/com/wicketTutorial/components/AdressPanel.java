package com.wicketTutorial.components;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.wicketTutorial.components.model.Address;

public class AdressPanel extends Panel {


    public AdressPanel(String id, IModel<Address> addressModel) {
        super(id, addressModel);
        Form<Address> form = new Form<Address>("form", new CompoundPropertyModel<Address>(addressModel));
        form.add(new TextField<String>("street"));
        form.add(new TextField<String>("postalCode"));
        add(form);
    }

}

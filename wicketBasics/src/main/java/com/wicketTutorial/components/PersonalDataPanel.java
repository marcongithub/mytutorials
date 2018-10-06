package com.wicketTutorial.components;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.wicketTutorial.components.model.PersonalData;

public class PersonalDataPanel extends Panel {

	public PersonalDataPanel(String id, IModel<PersonalData> model) {
		super(id, model);
		setOutputMarkupId(true);
		Form<PersonalData> form = new Form<PersonalData>("form", new CompoundPropertyModel<PersonalData>(model) {

			@Override
			public PersonalData getObject() {
				return super.getObject();
			}

			@Override
			public void setObject(PersonalData object) {
				super.setObject(object);
			}

			@Override
			public void detach() {
				// TODO Auto-generated method stub
				super.detach();
			}

		});
		form.add(new TextField<String>("name") {
			@Override
			public void setModelValue(String[] value) {
				// TODO Auto-generated method stub
				super.setModelValue(value);
			}
		});
		form.add(new TextField<String>("surname"));
		add(form);
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();
	}

	@Override
	protected void onModelChanged() {
		super.onModelChanged();
	}

	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();
	}

	@Override
	protected void onModelChanging() {
		super.onModelChanging();
	}

	@Override
	protected void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

}

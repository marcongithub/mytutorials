package com.wicketTutorial.border;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;

public abstract class MySiteBase extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();
		Border border = new MySiteBorder("myBorder");
		add(border);
		border.getBodyContainer().add(new Label("currentPage", getPageTitle()));
	}

	abstract String getPageTitle();

}

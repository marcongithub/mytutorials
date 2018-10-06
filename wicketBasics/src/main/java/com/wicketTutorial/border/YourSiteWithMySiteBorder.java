package com.wicketTutorial.border;

import org.apache.wicket.markup.html.WebPage;

public class YourSiteWithMySiteBorder extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new MySiteBorder("myBorder"));
	}

}

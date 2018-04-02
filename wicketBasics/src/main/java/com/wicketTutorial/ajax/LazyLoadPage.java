package com.wicketTutorial.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class LazyLoadPage extends WebPage{

	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(myLazyLoadPanel());
	}

	private AjaxLazyLoadPanel myLazyLoadPanel() {
		AjaxLazyLoadPanel myLazyLoadPanel = new AjaxLazyLoadPanel("lazyLoadPanel") {
			
			@Override
			public Component getLazyLoadComponent(String markupId) {
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				}
				return new Label(markupId,"Loaded");
			}
		};
		
		
		return myLazyLoadPanel;
	}
	
	
}

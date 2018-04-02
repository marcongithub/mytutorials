package com.wicketTutorial.tabbedpanel;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TabPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private boolean visibilityToggle;
	private WebMarkupContainer caree;
	private Label careeLabel;
	
	public TabPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		careeLabel=new Label("careeLabel","carees label");
//		careeLabel.setOutputMarkupId(true);
		careeLabel.setOutputMarkupPlaceholderTag(true);
		careeLabel.setVisible(visibilityToggle);
		
		caree=new WebMarkupContainer("caree");
//		caree.setOutputMarkupId(true);
		caree.add(careeLabel);
		add(caree);
		caree.add(new AjaxEventBehavior("onclick") {
			private static final long serialVersionUID = 1L;
			
			protected void onEvent(AjaxRequestTarget target) {
				target.add(TabPanel.this);
				visibilityToggle=!visibilityToggle;
				careeLabel.setVisible(visibilityToggle);
				
//				TextTemplate textTemplate = new PackagedTextTemplate(getClass(), "content.js");
//				target.appendJavascript(textTemplate.asString());
			}			
			
        });
	}

}

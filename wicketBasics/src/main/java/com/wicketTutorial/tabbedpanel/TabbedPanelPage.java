package com.wicketTutorial.tabbedpanel;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class TabbedPanelPage extends WebPage{
	
	TabPanel1 tabpanel1;
	TabPanel tabpanel;
	public TabbedPanelPage() {
//		
//		HeaderContributor cssHeaderContributor=CSSPackageResource.getHeaderContribution(new ResourceReference("styles"));
//		add(cssHeaderContributor);
//		HeaderContributor jsHeaderContributor=JavascriptPackageResource.getHeaderContribution(new ResourceReference("js"));
//		add(jsHeaderContributor);
		
		List<ITab> tabs = new ArrayList<ITab>();
		
		
		
		tabs.add(new AbstractTab(new Model<String>("first tab")) {
			public Panel getPanel(String panelId) {
				if(tabpanel1==null)
					tabpanel1=new TabPanel1(panelId);
				return tabpanel1;
			}
		});

//		tabs.add(new AbstractTab(new Model<String>("second tab")) {
//			public Panel getPanel(String panelId) {
//				if(tabpanel1==null)
//					tabpanel1=new TabPanel1(panelId);
//				return tabpanel1; 
//			}
//		});

		tabs.add(new AbstractTab(new Model<String>("third tab")) {
			public Panel getPanel(String panelId) {
				if(tabpanel==null)
					tabpanel=new TabPanel(panelId);
				return tabpanel;
			}
		});

		add(new AjaxTabbedPanel("tabs", tabs){

			@Override
			protected void onAjaxUpdate(AjaxRequestTarget target) {
				super.onAjaxUpdate(target);
				System.out.println("asdfdasf");
//				TextTemplate textTemplate = new PackagedTextTemplate(WicketApplication.class, "hover.js");
//				target.appendJavaScript(textTemplate.asString());
			}
			
		});
		
		
	}

	

}

package com.wicketTutorial;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.wicketTutorial.ajax.DecorateCallPage;
import com.wicketTutorial.ajax.LazyLoadPage;
import com.wicketTutorial.callbacks.Callbacks;
import com.wicketTutorial.components.CarRentalPage;
import com.wicketTutorial.components.CustomerDataPage;
import com.wicketTutorial.js.MarkupWithJsPage;
import com.wicketTutorial.jsToWicket.JsToWicket;
import com.wicketTutorial.ressourcen.RessourcenTest;
import com.wicketTutorial.tabbedpanel.TabbedPanelPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.wicketTutorial.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	
	public static String APP_WIDE_CSS="app-wide.css";

	/**
	 * Constructor
	 */
	public WicketApplication() {

		
		

	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		this.mountPage("/markupjs", MarkupWithJsPage.class);
		
		
		this.mountPage("/test1", TestPage1.class);
		this.mountPage("/test2", TestPage2.class);
		this.mountPage("/jstowicket", JsToWicket.class);
		this.mountPage("/callback", Callbacks.class);
		this.mountPage("/tabs", TabbedPanelPage.class);
		this.mountPage("/comps", CustomerDataPage.class);
		this.mountPage("/restest", RessourcenTest.class);
		this.mountPage("/cars", CarRentalPage.class);
		this.mountPage("/decorajax", DecorateCallPage.class);
		this.mountPage("/lazyload", LazyLoadPage.class);
		
		
		
		IResource appWideJs = new JavaScriptResourceReference(getClass(), "app-wide.js").getResource();
		getSharedResources().add("app-wide-js-key", appWideJs);
		
		IResource jqueryUI = new JavaScriptResourceReference(getClass(), "jquery-ui.js").getResource();
		getSharedResources().add("jquery-ui", jqueryUI);
		
		
//		getJavaScriptLibrarySettings().setJQueryReference(new AnotherVersionOfJQueryReference());
	}

}
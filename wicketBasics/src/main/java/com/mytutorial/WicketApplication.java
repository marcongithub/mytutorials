package com.mytutorial;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.mytutorial.ajax.DecorateCallPage;
import com.mytutorial.ajax.LazyLoadPage;
import com.mytutorial.callbacks.Callbacks;
import com.mytutorial.components.CarRentalPage;
import com.mytutorial.components.CustomerDataPage;
import com.mytutorial.jsToWicket.JsToWicket;
import com.mytutorial.ressourcen.RessourcenTest;
import com.mytutorial.tabbedpanel.TabbedPanelPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.mytutorial.Start#main(String[])
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
	}

}

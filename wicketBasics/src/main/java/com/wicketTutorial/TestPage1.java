package com.wicketTutorial;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.ContextRelativeResource;
import org.apache.wicket.request.resource.ContextRelativeResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.apache.wicket.settings.IJavaScriptLibrarySettings;

public class TestPage1 extends WebPage {

//	ContextRelativeResourceReference resource = new ContextRelativeResourceReference(
//			"js/jquery-ui-1.11.4/hugo.js", false);
	ContextRelativeResourceReference resource = new ContextRelativeResourceReference(
			"/js/hugo.js", false) {
	};

	@Override
	protected void onInitialize() {
		super.onInitialize();

		// add(new AjaxLink<Void>("submitLink") {
		// @Override
		// public void onClick(AjaxRequestTarget target) {
		//
		// }
		//
		// });
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		

		
		
		String contextPath = WebApplication.get().getServletContext().getContextPath();
		
		CharSequence url = RequestCycle.get().urlFor(resource, getPageParameters());
		
		
		IJavaScriptLibrarySettings javaScriptSettings = getApplication().getJavaScriptLibrarySettings();
//		response.render(JavaScriptHeaderItem.forReference(javaScriptSettings.getJQueryReference()));

		// der scheißdreck funktioniert nicht
//		response.render(JavaScriptHeaderItem.forReference(resource, true));
		
		response.render(JavaScriptReferenceHeaderItem.forReference(resource));
		
		

		// response.render(JavaScriptHeaderItem.forReference(new
		// SharedResourceReference("jquery-ui")));
	}

	@Override
	public void renderHead(HtmlHeaderContainer container) {
		super.renderHead(container);

	}

}

package com.wicketTutorial.ressourcen;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;

import com.wicketTutorial.WicketApplication;

public class RessourcenTest extends WebPage {

	public RessourcenTest() {

		WebMarkupContainer caree = new WebMarkupContainer("caree");
		caree.setOutputMarkupId(true);
		add(caree);
		caree.add(new AjaxEventBehavior("onclick") {

			// um ausgelagertes javascript an die ajax response zu hängen muß man JsTemplate
			// verwenden
			protected void onEvent(AjaxRequestTarget target) {
				// TODO: ein paar header items hinzufügen und Reihenfolge beobachten

				// TextTemplate textTemplate = new PackageTextTemplate(WicketApplication.class,
				// "app-wide.js");
				// JavaScriptTemplate jsTemplate = new JavaScriptTemplate(textTemplate);
				//
				// CharSequence javascript = jsTemplate.asString();
				// target.appendJavaScript(javascript);
				// jsTemplate.close();
				// // target.getHeaderResponse().render(item);

			}

			// add resource in 'behaviors head'
			@Override
			public void renderHead(Component component, IHeaderResponse response) {
				super.renderHead(component, response);
				JavaScriptResourceReference js2 = new JavaScriptResourceReference(getClass(), "jscript2.js");
				response.render(JavaScriptHeaderItem.forReference(js2));
			}

		});
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// two ways of adding shared ressources
		response.render(JavaScriptHeaderItem.forReference(new SharedResourceReference("app-wide-js-key")));
		response.render(CssHeaderItem
				.forReference(new PackageResourceReference(WicketApplication.class, WicketApplication.APP_WIDE_CSS)));

	}

}

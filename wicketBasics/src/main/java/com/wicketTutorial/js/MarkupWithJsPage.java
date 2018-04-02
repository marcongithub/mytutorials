package com.wicketTutorial.js;

import java.util.Arrays;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class MarkupWithJsPage extends WebPage {

	 

	@Override
	public void renderHead(IHeaderResponse response) {
		
		CharSequence javascript = "console.log('jsLiteral: hello wicket!');";
		response.render(JavaScriptHeaderItem.forScript(javascript, "jsLiteral"));
		
		//wont work if we dont render the jquery library as well!
		// CharSequence javascript =
		// "$(document).ready(function(){console.log('jsLiteral: on load aka onDomReady
		// called!');});";

		response.render(JavaScriptHeaderItem.forReference(referenceToHelloJs()));

		renderJQueryUI(response);
	}

	private ResourceReference referenceToHelloJs() {
		ResourceReference packageReference = new PackageResourceReference(getClass(), "hello.js") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem());
			}
		};
		return packageReference;
	}
	
	private JavaScriptReferenceHeaderItem jqueryRefHeaderItem() {
		ResourceReference jqueryRef = Application.get().getJavaScriptLibrarySettings().getJQueryReference();
		return JavaScriptHeaderItem.forReference(jqueryRef);
	}
	
	
	//TODO: complete jqueryUI example, add some shared ressource 
	private void renderJQueryUI(IHeaderResponse response) {
		ResourceReference packageReference = new PackageResourceReference(getClass(), "jquery-ui.js") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem());
			}
		};
		
	}

}

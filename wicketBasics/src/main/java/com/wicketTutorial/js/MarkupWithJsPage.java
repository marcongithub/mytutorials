package com.wicketTutorial.js;

import java.util.Arrays;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;

public class MarkupWithJsPage extends WebPage {

	@Override
	public void renderHead(IHeaderResponse response) {

		response.render(JavaScriptHeaderItem.forScript("console.log('hello 1!');", "jsLiteral-2"));
		response.render(JavaScriptHeaderItem.forScript("console.log('hello 2!');", "jsLiteral-1"));

		response.render(OnLoadHeaderItem.forScript("console.log('hello on OnLoadHeaderItem (lifecycle event Load)');"));
		response.render(OnDomReadyHeaderItem
				.forScript("console.log('hello on OnDomReadyHeaderItem (lifecycle event DOMContentLoaded)');"));

		// $(document).ready in script wont work if we dont include the jquery library
		response.render(JavaScriptHeaderItem.forReference(referenceToFooJs()));

		// includes jquery ui library
		response.render(JavaScriptHeaderItem.forReference(referenceToBarJs()));
		
		// includes jquery ui library again
		response.render(JavaScriptHeaderItem.forReference(referenceToSortableJs()));

	}

	private ResourceReference referenceToFooJs() {
		ResourceReference packageReference = new PackageResourceReference(getClass(), "foo.js") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem());
			}
		};
		return packageReference;
	}

	private ResourceReference referenceToBarJs() {
		ResourceReference packageReference = new PackageResourceReference(getClass(), "bar.js") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem(), jqueryUIrefHeaderItem());
			}
		};
		return packageReference;
	}
	
	private ResourceReference referenceToSortableJs() {
		ResourceReference packageReference = new PackageResourceReference(getClass(), "sortable.js") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem(), jqueryUIrefHeaderItem());
			}
		};
		return packageReference;
	}

	private JavaScriptReferenceHeaderItem jqueryRefHeaderItem() {
		ResourceReference jqueryRef = Application.get().getJavaScriptLibrarySettings().getJQueryReference();
		return JavaScriptHeaderItem.forReference(jqueryRef);
	}

	private JavaScriptReferenceHeaderItem jqueryUIrefHeaderItem() {
		ResourceReference jqueryUIref = new SharedResourceReference("jqueryUI") {
			@Override
			public Iterable<? extends HeaderItem> getDependencies() {
				return Arrays.asList(jqueryRefHeaderItem());
			}
		};
		return JavaScriptHeaderItem.forReference(jqueryUIref);
	}

}

package com.mytutorial.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxIndicatorAware;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.AjaxIndicatorAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class DecorateCallPage extends WebPage implements IAjaxIndicatorAware {

	private static int counter = 0;
	private String labelText = "Nr of calls:";

	private AjaxIndicatorAppender indicatorAppender = new AjaxIndicatorAppender();

	@Override
	protected void onInitialize() {
		super.onInitialize();
		final Label label = new Label("myLabel", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return labelText + counter++;
			}
		});
		label.setOutputMarkupId(true);
		label.setMarkupId("myLabel");
		add(label);
		final AjaxLink<Void> myLink = new AjaxLink<Void>("ajaxLink") {
			
			@Override
			public void renderHead(IHeaderResponse response) {
				super.renderHead(response);
				response.render(JavaScriptHeaderItem.forScript("console.log('executing js in component header...');", "id-42"));
			}

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				attributes.getAjaxCallListeners().add(myAjaxCallListener());
				super.updateAjaxAttributes(attributes);
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.add(label);
				target.appendJavaScript("console.log('executing appended js in onClick...');");  
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
				}
			}
		};
		myLink.setMarkupId("myLink");
		add(myLink);
		add(indicatorAppender);

	}

	private IAjaxCallListener myAjaxCallListener() {
		IAjaxCallListener myAjaxCallListener = new AjaxCallListener() {
			@Override
			public CharSequence getBeforeHandler(Component component) {
				return "console.log('executing beforeHandler...'); $('#myLink').prop('disabled', true);";
			}

			@Override
			public CharSequence getAfterHandler(Component component) {
				return "console.log('executing afterHandler...');";
			}

			@Override
			public CharSequence getSuccessHandler(Component component) {
				return "console.log('executing successHandler...'); $('#myLink').prop('disabled', false); ";
			}

		};
		return myAjaxCallListener;
	}

	@Override
	public String getAjaxIndicatorMarkupId() {
		return indicatorAppender.getMarkupId();
	}

}

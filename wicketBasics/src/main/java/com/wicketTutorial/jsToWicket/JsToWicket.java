package com.wicketTutorial.jsToWicket;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptContentHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

/**
 * behave1: Zeigt die Kommunikation von js -> wicket und wie man mithilfe des
 * visitor patterns über http parameter wicket componenten findet In behave2
 * wird ein js ajax call auf ein behavior ausgeführt, über den mitgelieferten
 * http parameter (markup id) die wicket componente gesucht. Auf der Komponente
 * wird ein behaviour ausgeführt das den css style ändert (AttributeModifier).
 * Damit das ganze funktioniert muß die componente dann noch an den
 * AjaxRequestTarget der respond methode des aufgerufenen behaviors angehängt
 * werden.
 * 
 * behave2: Zeigt die Kommunikation von js -> wicket -> js In behave2 wird ein
 * js ajax call auf ein behavior ausgeführt, eine wicket componente (caree1)
 * aktualisiert und anschschließend ein anderes js ausgeführt
 * 
 * 
 * @author marco
 *
 */
public class JsToWicket extends WebPage {

	static int toggle = 0;

	private AbstractDefaultAjaxBehavior behave1;
	private AbstractDefaultAjaxBehavior behave2;
	WebMarkupContainer backlogListContainer;
	Component selectedComponent = null;

//	@Override
//	protected void onInitialize() {
//		super.onInitialize();
////		add(new AjaxLink<Void>("submitLink") {
////			@Override
////			public void onClick(AjaxRequestTarget target) {
////
////			}
////
////		});
//	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		final WebMarkupContainer caree1 = new WebMarkupContainer("caree1");
		caree1.setOutputMarkupId(true);
		caree1.setMarkupId("c1");
		WebMarkupContainer caree2 = new WebMarkupContainer("caree2");
		caree2.setOutputMarkupId(true);
		caree2.setMarkupId("c2");
		add(caree1);
		add(caree2);
		ListView<Task> backlogList = new ListView<Task>("backlogList", new ListModel<Task>(this.getBacklog())) {

			@Override
			protected void populateItem(ListItem<Task> item) {
				Task task = item.getModelObject();
				Label label = new Label("task", task.getLabel());
				item.add(label);
				item.setOutputMarkupId(true);
				item.setMarkupId(task.getId());
			}

		};

		backlogListContainer = new WebMarkupContainer("backlogListContainer");
		backlogListContainer.setOutputMarkupId(true);
		backlogListContainer.add(backlogList);
		add(backlogListContainer);
		/*
		 * BEHAVIOR 1 #################################
		 */
		behave1 = new AbstractDefaultAjaxBehavior() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void respond(AjaxRequestTarget target) {
				final String paramMarkupId = RequestCycle.get().getRequest().getQueryParameters()
						.getParameterValue("markupId").toString();
				System.out.println("paramMarkupId " + paramMarkupId);

				JsToWicket.this.visitChildren(WebMarkupContainer.class, getVisitor(paramMarkupId));
				target.add(selectedComponent);
			}

			private IVisitor<WebMarkupContainer, IVisit<Void>> getVisitor(final String paramMarkupId) {
				IVisitor<WebMarkupContainer, IVisit<Void>> visitor = new IVisitor<WebMarkupContainer, IVisit<Void>>() {

					@Override
					public void component(WebMarkupContainer component, IVisit<IVisit<Void>> visit) {
						String markupId = component.getMarkupId();
						System.out.println("markupId of visited component: " + markupId);
						if (StringUtils.equals(markupId, paramMarkupId)) {
							System.out.println(" was clicked on!");
							selectedComponent = component;
							component.add(new AttributeModifier("style", new Model<String>("background-color: blue;")));
						}

					}
				};
				return visitor;
			}

		};
		add(behave1);
		/*
		 * BEHAVIOR 2 #################################
		 */
		behave2 = new AbstractDefaultAjaxBehavior() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void respond(AjaxRequestTarget target) {

				final String liId = RequestCycle.get().getRequest().getQueryParameters().getParameterValue("liId")
						.toString();

				final String previousLiId = RequestCycle.get().getRequest().getQueryParameters()
						.getParameterValue("previousLiId").toString();
				System.out.println("liId " + liId + " previousLiId " + previousLiId);
				String bgColor = (toggle % 2 == 0) ? "background-color: green;" : "background-color: red;";
				caree1.add(new AttributeModifier("style", new Model<String>(bgColor)));
				target.add(caree1);
				String js = "var bgColor=$('#c1').css('background-color');$('#outPut').append(bgColor);";
				target.appendJavaScript(js);
				toggle++;
			}
		};
		add(behave2);
		add(new Behavior() {
			@Override
			public void renderHead(Component component, IHeaderResponse response) {
				String js1 = "function callWicket(markupId) { var wcall = wicketAjaxGet ('" + behave1.getCallbackUrl()
						+ "&markupId='+markupId, function() { }, function() { } ) }";
				response.render(JavaScriptContentHeaderItem.forScript(js1, "js1-id"));
				String js2 = "function onSort(liId,previousLiId) { var wcall = wicketAjaxGet ('"
						+ behave2.getCallbackUrl()
						+ "&liId='+liId+'&previousLiId='+previousLiId, function() { }, function() { } ) }";
				response.render(JavaScriptContentHeaderItem.forScript(js2, "js2-id"));
				// wicket 1.5 style
				// response.renderJavascript(js2, "myScript2");
			}
		});

	}

	private List<Task> getBacklog() {
		return Arrays.asList(new Task("id1", 0, "task a"), new Task("id2", 0, "task b"), new Task("id3", 0, "task c"));
	}

}

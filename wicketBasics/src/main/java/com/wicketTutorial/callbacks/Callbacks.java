package com.wicketTutorial.callbacks;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class Callbacks extends WebPage{
    WebMarkupContainer aContainer;
    
    public Callbacks() {
        super();
        aContainer=getMarkupContainer();
        add(aContainer);
        add(getAjaxLink()); 
    }

    private Component getAjaxLink() {
        AjaxLink<?> anAjaxLink=new AjaxLink<Object>("anAjaxLink"){
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target) {
                
            }

            
        };
        return anAjaxLink;
    }

    private WebMarkupContainer getMarkupContainer() {
        WebMarkupContainer aContainer=new WebMarkupContainer("aContainer"){

            @Override
            public boolean isVisible() {
                return super.isVisible();
            }

            @Override
            protected void onBeforeRender() {
                super.onBeforeRender();
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }

            @Override
            protected void onConfigure() {
                super.onConfigure();
            }
            
        };
        return aContainer;
    }

  

    
    
}

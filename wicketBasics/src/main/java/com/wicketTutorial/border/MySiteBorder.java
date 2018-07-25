package com.wicketTutorial.border;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;

/**
 * @author marco.bernasconi@mnet-online.de
 *
 */
public class MySiteBorder extends Border {

	public MySiteBorder(String id) {
		super(id);
		addToBorder(new Label("username", "Horsti"));
		addToBorder(new Label("lastLogin", "Grad eben"));
	}

}

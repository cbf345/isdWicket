package org.wicket_kkato.learning.isd;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class Header extends Panel{
	public Header(String id,String name){
		super(id);
		add(new Label("name",name));
	}

}

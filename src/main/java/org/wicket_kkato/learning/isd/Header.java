package org.wicket_kkato.learning.isd;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class Header extends Panel{
	public Header(String id,IModel<String> name){
		super(id);
		add(new Label("name",name));
	}

}

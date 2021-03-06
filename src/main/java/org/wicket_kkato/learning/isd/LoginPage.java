package org.wicket_kkato.learning.isd;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class LoginPage extends WebPage{
	private static final long serialVersionUID = 1L;

	TestManagementDAO dao = new TestManagementDAO();

	private IModel<String> nameModel;
	private IModel<String> passwordModel;

	public LoginPage(){
		nameModel = new Model<>("");
		passwordModel = new Model<>("");

		Form<Void> form = new Form<Void>("form"){

			protected void onSubmit(){
				super.onSubmit();
				if(dao.confirmAccount(nameModel.getObject(), passwordModel.getObject())){
					setResponsePage(new ProductList(nameModel));
				}else{
					setResponsePage(new LoginPage());
				}
//				setResponsePage(new ProductList(nameModel));
			}
		};
		add(form);

		TextField<String> nameField = new TextField<String>("name",nameModel);
		form.add(nameField);
		TextField<String> passwordField = new TextField<String>("password",passwordModel);
		form.add(passwordField);
	}

}

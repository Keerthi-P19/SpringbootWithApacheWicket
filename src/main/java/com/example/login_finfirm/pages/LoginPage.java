package com.example.login_finfirm.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.form.PasswordTextField;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class LoginPage extends WebPage {

	public LoginPage() {
		Form<Void> form = new Form<Void>("loginForm") {
			@Override
			protected void onSubmit() {
				setResponsePage(HelloPage.class);
			}
		};
		form.add(new TextField<>("username", Model.of("")));
		form.add(new PasswordTextField("password", Model.of("")));
		add(form);
	}

}

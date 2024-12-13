package com.example.login_finfirm.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloPage extends WebPage {

	public HelloPage() {
		add(new Label("message", "Hello, authenticated user!"));
	}

}

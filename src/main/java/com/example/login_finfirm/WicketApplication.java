package com.example.login_finfirm;

import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.stereotype.Component;

import com.example.login_finfirm.pages.LoginPage;

@Component
public class WicketApplication extends WebApplication{

	@Override
	public Class<? extends org.apache.wicket.Page> getHomePage() {
		return LoginPage.class;
	}

}

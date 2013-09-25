package org.vaadin.example.shiro;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

public class ExampleUI extends UI {

	@WebServlet(value = "/*")
	@VaadinServletConfiguration(productionMode = false, ui = ExampleUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(this, this);

		navigator.addView("", LoginView.class);
		navigator.addView("secure", SecureView.class);
	}

}

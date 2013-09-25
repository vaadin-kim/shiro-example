package org.vaadin.example.shiro;

import javax.servlet.annotation.WebServlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

public class ExampleUI extends UI implements ViewChangeListener {

	@WebServlet(value = "/*")
	@VaadinServletConfiguration(productionMode = false, ui = ExampleUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(this, this);
		navigator.addViewChangeListener(this);

		navigator.addView("", LoginView.class);
		navigator.addView("secure", SecureView.class);
	}

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()
				&& event.getViewName().equals("")) {
			event.getNavigator().navigateTo("secure");
			return false;
		}

		if (!currentUser.isAuthenticated()
				&& !event.getViewName().equals("")) {
			event.getNavigator().navigateTo("");
			return false;
		}

		return true;
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

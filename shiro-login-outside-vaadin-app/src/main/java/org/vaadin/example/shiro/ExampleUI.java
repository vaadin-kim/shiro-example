package org.vaadin.example.shiro;

import javax.servlet.annotation.WebServlet;

import org.apache.jasper.servlet.JspServlet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("shiroexample")
public class ExampleUI extends UI {

	@WebServlet(value = "/*" )
	@VaadinServletConfiguration(productionMode = false, ui = ExampleUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@WebServlet(value="/login.jsp")
	public static class MyJspServlet extends JspServlet {
		
	}
	

	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(this, this);

		navigator.addView("", SecureView.class);
		navigator.setErrorView(ErrorView.class);
	}

}

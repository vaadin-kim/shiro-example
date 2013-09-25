package org.vaadin.example.shiro;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SecureView extends VerticalLayout implements View {

	public SecureView() {
		Logger.getLogger(getClass().getCanonicalName()).log(Level.INFO,
				"Initializing secure view");
		addComponent(new Label(
				"This is a secure view that you shouldn't see unless you are logged in"));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}

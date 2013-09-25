package org.vaadin.example.shiro;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class SecureView extends VerticalLayout implements View {

	private boolean initialized;

	private void build() {
		Logger.getLogger(getClass().getCanonicalName()).log(Level.INFO,
				"Initializing secure view");
		Label label = new Label(
				"Super secret documentation of your project");
		label.setStyleName(Reindeer.LABEL_H1);
		addComponent(label);
		BrowserFrame embedded = new BrowserFrame();
		embedded.setSource(new ThemeResource("secret.pdf"));
		embedded.setWidth("600px");
		embedded.setHeight("400px");
		addComponent(embedded);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (!initialized) {
			build();
			initialized = true;
		}

	}

}

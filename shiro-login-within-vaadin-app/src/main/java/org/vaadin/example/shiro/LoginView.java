package org.vaadin.example.shiro;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class LoginView extends FormLayout implements View, ClickListener {

	private TextField username = new TextField("Username");
	private PasswordField password = new PasswordField("Password");
	private Button loginBtn = new Button("Login", this);
	private Label invalidPassword = new Label("Invalid username or password");

	public LoginView() {
		addComponent(username);
		addComponent(password);
		addComponent(loginBtn);
		addComponent(invalidPassword);
		invalidPassword.setVisible(false);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buttonClick(ClickEvent event) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				username.getValue(), password.getValue());
		try {
			currentUser.login(token);
			getUI().getNavigator().addView("secure", SecureView.class);
			getUI().getNavigator().navigateTo("secure");
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
			username.setValue("");
			password.setValue("");
			invalidPassword.setVisible(true);
		}

	}

}

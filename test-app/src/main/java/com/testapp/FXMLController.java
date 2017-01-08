package com.testapp;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public abstract class FXMLController implements InitializingBean {

	protected Node view;

	protected String fxmlFilePath;

	public abstract void setFxmlFilePath(String filePath);

	public FXMLController() {
		super();
	}

	public abstract void initialize();

	public void afterPropertiesSet() throws Exception {
		loadFXML();
	}

	protected final void loadFXML() throws IOException {
		try (InputStream fxmlStream = getClass().getResourceAsStream(fxmlFilePath)) {
			FXMLLoader loader = new FXMLLoader();
			loader.setController(this);
			this.view = (loader.load(fxmlStream));
		}
	}

	public Node getView() {
		return view;
	}
}

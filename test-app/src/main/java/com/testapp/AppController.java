package com.testapp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class AppController extends FXMLController {

	public AppController() {
		super();
	}

	private static final AtomicLong counter = new AtomicLong(1);

	@FXML
	Button btn;

	@FXML
	TextField input;

	@FXML
	Label btnMessage;

	@FXML
	Label output;

	@FXML
	public void showOutput() {
		btnMessage.setText(String.format("Counter: %d", counter.getAndIncrement()));
	}

	@Value("${fxml.demo.view}")
	@Override
	public void setFxmlFilePath(String filePath) {
		this.fxmlFilePath = filePath;
	}

	@Override
	public void initialize() {
		output.textProperty().bind(input.textProperty());
	}
}

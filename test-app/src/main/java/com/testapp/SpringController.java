package com.testapp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("de.codelife.demoproject")
@PropertySource("classpath:application.properties")
public class SpringController {

	private static final Logger LOG = Logger.getLogger(SpringController.class.getName());

	private ApplicationContext appContext;

	public void bootSpring() {
		appContext = new AnnotationConfigApplicationContext(SpringController.class);
		String name = appContext.getEnvironment().getProperty("application.name");
		String version = appContext.getEnvironment().getProperty("application.version");
		LOG.log(Level.INFO, String.format("%s %s wurde gestartet", name, version));
	}
}

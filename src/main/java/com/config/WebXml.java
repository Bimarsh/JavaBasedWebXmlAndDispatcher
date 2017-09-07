package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer {

	public void onStartup(ServletContext arg0) throws ServletException {
		//register context
		AnnotationConfigWebApplicationContext context= new AnnotationConfigWebApplicationContext();
		context.register(DispatcherConfig.class);
		
		//add listener
		arg0.addListener(new ContextLoaderListener(context));
		
		//Servlet Registration
		ServletRegistration.Dynamic dispatcher=arg0.addServlet("dispatcher",new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}

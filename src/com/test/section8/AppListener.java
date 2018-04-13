package com.test.section8;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext=arg0.getServletContext();
		Map<String,String> countries=new HashMap<String,String>();
		countries.put("ca", "Canada");
		countries.put("us", "United States");
		servletContext.setAttribute("countries", countries);
	}

}

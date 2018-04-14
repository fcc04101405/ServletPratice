package com.test.section8;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletcontextevent) {
		ServletContext servletContext = servletcontextevent.getServletContext();
		servletContext.setAttribute("userCounter", new AtomicInteger());

	}

	@Override
	public void sessionCreated(HttpSessionEvent httpsessionevent) {
		HttpSession session = httpsessionevent.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.incrementAndGet();
		session.setAttribute("Product", new Product("aaa", "bbb", 95.1));//≥¢ ‘HttpSessionBindingListener∑Ω∑®
		System.out.println("userCount incremented to :" + userCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {
		HttpSession session = httpsessionevent.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.decrementAndGet();
		System.out.println("userCount decremented to :" + userCount);
	}

}

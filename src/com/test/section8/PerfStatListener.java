package com.test.section8;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
@WebListener
public class PerfStatListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		ServletRequest servletRequest=servletrequestevent.getServletRequest();
		Long start=(Long) servletRequest.getAttribute("start");
		Long end=System.nanoTime();
		HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
		String uri=httpServletRequest.getRequestURI();
		System.out.println("time taken to execute "+uri+":"+((end-start)/1000)+"microseconds");
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		ServletRequest servletRequest=servletrequestevent.getServletRequest();
		servletRequest.setAttribute("start", System.nanoTime());
	}

}

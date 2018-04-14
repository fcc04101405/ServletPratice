package com.test.section8;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements HttpSessionBindingListener {
	private String id;
	private String name;
	private double price;
	public Product(String id,String name,double price){
		this.id=id;
		this.name=name;
		this.price=price;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent httpsessionbindingevent) {
		String attributeName=httpsessionbindingevent.getName();
		System.out.println(attributeName+"valueBound");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpsessionbindingevent) {
		String attributeName=httpsessionbindingevent.getName();
		System.out.println(attributeName+"valueUnBound");
	}

}

package com.test.sectionA;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 2381986249968750150L;
	private String name;
	private String decription;
	private float price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}

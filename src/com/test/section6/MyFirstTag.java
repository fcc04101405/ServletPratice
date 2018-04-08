package com.test.section6;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyFirstTag implements SimpleTag {
	JspContext jspContext;

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
		jspContext.getOut().print("This is my first tag.");
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");

	}

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext");
		this.jspContext = arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}

package com.test.sectionA;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input", "/product_save" })
public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5380583591780981667L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		if(action.equals("product_input")) {
			
		}else if(action.equals("product_save")) {
			ProductForm productForm=new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setDecription(request.getParameter("decription"));
			productForm.setPrice(request.getParameter("price"));
			Product product=new Product();
			product.setName(productForm.getName());
			product.setDecription(productForm.getDecription());
			try {
				product.setPrice(Float.parseFloat(productForm.getPrice()));
			}catch(NumberFormatException e) {	
			}
			//写数据库部分忽略
			request.setAttribute("product", product);
		}
		String dispatchUrl=null;
		if(action.equals("product_input")) {
			dispatchUrl="/SectionA/ProductForm.jsp";
		}else if(action.equals("product_save")) {
			dispatchUrl="/SectionA/ProductDetails.jsp";
		}
		if(dispatchUrl!=null) {
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}

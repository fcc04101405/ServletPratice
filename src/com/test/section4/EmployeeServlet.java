package com.test.section4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address= new Address();
		address.setStreetName("Rue d'Anjou");
		address.setStreetNumber("5090B");
		address.setCity("Brossard");
		address.setState("Quebec");
		address.setZipCode("A1A B2B");
		address.setCountry("Canada");
		
		Employee employee=new Employee();
		employee.setId(1099);
		employee.setName("Charles Unjeye");
		employee.setAddress(address);
		request.setAttribute("employee", employee);
		Map<String,String> capitals=new HashMap<String,String>();
		capitals.put("China", "Beijing");
		capitals.put("Austria", "Vienna");
		capitals.put("Australia", "Canberra");
		capitals.put("Canada","Ottawa");
		request.setAttribute("capitals", capitals);
		javax.servlet.RequestDispatcher rd= request.getRequestDispatcher("/Section4/employee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

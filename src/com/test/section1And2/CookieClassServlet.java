package com.test.section1And2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieClassServlet
 */
@WebServlet("/CookieClassServlet")
public class CookieClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] methods = { "clone", "getComment", "getDomain", "getMaxAge", "getName", "getPath", "getSecure",
			"getValue", "getVersion", "isHttpOnly", "setComment", "setDomain", "setHttpOnly", "setMaxAge", "setPath",
			"setSecure", "setValue", "setVersion" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie maxRecordsCookie = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("maxRecords")) {
					maxRecordsCookie = cookie;
					break;
				}
			}
		}
		int maxRecords = 5;
		if (maxRecordsCookie != null) {
			try {
				maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
			} catch (NumberFormatException e) {

			}
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head>" + "<title>Cookie Class</title>" + "</head><body>" + PreferenceServlet.MENU
				+ "<div>Here are some of the methods in " + "javax.servlet.http.cookie");
		writer.print("<ul>");
		
		for(int i=0; i<maxRecords;i++){
			writer.print("<li>"+methods[i]+"</li>");
		}
		writer.print("</ul>");
		writer.print("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.test.section5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books=new ArrayList<Book>();
		Book book1=new Book("978-0980839616","Java 7: A Beginner's Tutorial",45.00);
		Book book2=new Book("978-0980331608","Struts 2 Design and Programming:A Tutorial",49.95);
		Book book3=new Book("978-0975212820","Dimensional Data Warehousing with MySQL:A Tutorial",39.95);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		request.setAttribute("books", books);
		RequestDispatcher rd=request.getRequestDispatcher("Section5/books.jsp");
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

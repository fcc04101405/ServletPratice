package com.test.sectionC;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.RequestDispatcher;
import org.omg.CORBA_2_3.portable.OutputStream;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session==null||session.getAttribute("loggedIn")==null){
			javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			//must return after dispatcher.forward().Otherwise,
			//the code below will be executed
			return;
		}
		String dataDirectory=request.getServletContext().getRealPath("/WEB-INF/data");
		System.out.println(dataDirectory);
		File file=new File(dataDirectory,"Shadow Warrior 2 Artbook.pdf");
		if(file.exists()){
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=Shadow Warrior 2 Artbook.pdf");
			byte[] buffer=new byte[1024];
			FileInputStream fis=null;
			BufferedInputStream bis=null;
			try{
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				ServletOutputStream os=response.getOutputStream();
				int i=bis.read(buffer);
				while(i!=-1){
					os.write(buffer, 0, i);
					i=bis.read(buffer);
				}
			}catch(IOException ex){
				System.out.println(ex.toString());
			}finally{
				if(bis!=null){
					bis.close();
				}
				if(fis!=null){
					fis.close();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

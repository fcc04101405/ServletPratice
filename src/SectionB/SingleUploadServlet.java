package SectionB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = { "/SectionB/singleUpload" })
@MultipartConfig
public class SingleUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8530616070541618981L;

	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("filename");
		String fileName = getFilename(part);
		if (fileName != null && !fileName.isEmpty()) {
			part.write(getServletContext().getRealPath("/WEB-INF") + "/" + fileName);
			System.out.println(getServletContext().getRealPath("/WEB-INF")+"/"+fileName);
		}
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("<br/>Uploaded file name: " + fileName);
		writer.print("<br/>Size: " + part.getSize());

		String author = req.getParameter("author");
		writer.print("<br/>Author: " + author);
	}
}

package SectionB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MultipleUploadsServlet
 */
@WebServlet("/SectionB/MultipleUploads")
@MultipartConfig
public class MultipleUploadsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultipleUploadsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		System.out.println(contentDispositionHeader);
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		Collection<Part> parts=request.getParts();
		for(Part part:parts){
			if(part.getContentType()!=null){
				String fileName=getFilename(part);
				if(fileName!=null&&!fileName.isEmpty()){
					part.write(getServletContext().getRealPath("/WEB-INF")+"/"+fileName);
					writer.print("<br/>Uploaded file name: "+fileName);
					writer.print("<br/>Size: "+part.getSize());
					System.out.println(getServletContext().getRealPath("/WEB-INF")+"/"+fileName);
				}
			}else{
				String partName=part.getName();
				String fieldValue=request.getParameter(partName);
				writer.print("<br/>"+partName+": "+fieldValue);
			}
		}
	}

}

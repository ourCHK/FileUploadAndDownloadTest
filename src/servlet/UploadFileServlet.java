package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(location="/home/chk/FileFloder")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> enumeration = request.getHeaderNames();
		System.out.println("headers:");
		while (enumeration.hasMoreElements()) {
			String paramName = enumeration.nextElement();
			String paramValue = request.getHeader(paramName);
			System.out.println("ParamName:"+paramName+"    paramValue"+paramValue);
		}
		
		System.out.println("Parameters:");
		Enumeration<String> enumerationParams = request.getParameterNames();
		while (enumerationParams.hasMoreElements()) {
			String paramName = enumerationParams.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println("param:"+paramName+"   paramValue:"+paramName);
		}
		
		System.out.println("Parts:");
		Collection<Part> c = request.getParts();
		Iterator<Part> it = c.iterator();
		while (it.hasNext()) {
			Part part = it.next();
			System.out.println("Part:"+part.getName());
			System.out.println("Part:"+part.getContentType());
			System.out.println("Part:"+part.getSize());
			
			Collection<String> cPart  = part.getHeaderNames();
			Iterator<String> itPart = cPart.iterator();
			while (itPart.hasNext()) {
				String param = itPart.next();
				String paramvalue = part.getHeader(param);
				System.out.println("ParamName:"+param+"    paramValue"+paramvalue);
			}
		}
		
		ArrayList<Part> parts = new ArrayList<Part>(request.getParts());
		System.out.println("size:"+parts.size());
		for (int i=0;i<parts.size();i++) {
			Part part = parts.get(i);
			String content_disposition = part.getHeader("content-disposition");
			String fileName = "";
			if (content_disposition != null && !content_disposition.isEmpty()) {
				fileName = getFileName(content_disposition);
				if (fileName != null && fileName.isEmpty()) {
					continue;
				}
			}
			System.out.println("FileName:"+fileName);
			part.write(fileName);
		}
		
		
		PrintWriter pw = response.getWriter();
		pw.write("access success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 
	/**
	 * get the file name in content disposition
	 * @param content_disposition
	 * @return
	 */
	String getFileName(String content_disposition) {
		int startIndex = content_disposition.lastIndexOf("filename");
		if (startIndex == -1)
			return "";
		String fileNameString = content_disposition.substring(startIndex);
		int endIndex = fileNameString.lastIndexOf(" ");
		if (endIndex != -1) {
			fileNameString = fileNameString.substring(startIndex,endIndex);
		}
		
		String[] fileProperity = fileNameString.split("\"");
		return fileProperity[1];
	}

}
 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.apache.catalina.core.ApplicationPart;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(location="/home/chk/")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
		
//		System.out.println("Parts:");
//		Collection<Part> c = request.getParts();
//		Iterator<Part> it = c.iterator();
//		while (it.hasNext()) {
//			Part part = it.next();
//			System.out.println("Part:"+part.getName());
//			System.out.println("Part:"+part.getContentType());
//			System.out.println("Part:"+part.getSize());
//			
//			Collection<String> cPart  = part.getHeaderNames();
//			Iterator<String> itPart = cPart.iterator();
//			while (itPart.hasNext()) {
//				String param = itPart.next();
//				String paramvalue = part.getHeader(param);
////				String paramValue = request.getHeader(paramName);
//				System.out.println("ParamName:"+param+"    paramValue:"+paramvalue);
//			}
//		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");
		System.out.println("path:"+path);
		Part p = request.getPart("file1");
		
		if (p != null) {
			System.out.println(p.getContentType()+" "+p.getName());
		}
		
		ApplicationPart ap = (ApplicationPart) p;
		String fname1 = ap.getFilename();
		int path_idx = fname1.lastIndexOf("\\")+1;
		String fname2 = fname1.substring(path_idx, fname1.length());
		p.write("/home/chk/"+fname2);
		out.write("文件上传成功!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

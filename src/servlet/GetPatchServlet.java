package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPatchServlet
 */
@WebServlet("/GetPatchServlet")
public class GetPatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter pw = response.getWriter();
		String mPatchesPath = "/home/chk/patches";
		int version = -1;
		try {
			version = Integer.parseInt(request.getParameter("version"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("number format error");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unknown error, maybe nullpointerexception");
		} 
		
		if (version == -1) {
			PrintWriter pw = response.getWriter();
			pw.write("get app version fail");
			pw.flush();
			pw.close();
			return;
		}
		
		String patchPatch = mPatchesPath+"/"+version;
		File patchFiles  = new File(patchPatch);
		if (patchFiles.exists() && patchFiles.isDirectory()) {
			File[] patchList = patchFiles.listFiles();
			for (File patch:patchList) {
				if (patch.getName().equals("patch_signed_7zip.apk")) {
					response.setHeader("Content-Disposition","attachment; filename="+patch.getName()+"");
					response.setHeader("Content-length", patch.length()+"");
					FileInputStream fis = new FileInputStream(patch);
					int size = fis.available();
					byte[] bytes = new byte[size];
					fis.read(bytes);
					ServletOutputStream os = response.getOutputStream();
					os.write(bytes);
					os.flush();
					os.close();
				}
			}
		} else {
			PrintWriter pw = response.getWriter();
			pw.print(" patch no exist");
			pw.flush();
			pw.close();
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

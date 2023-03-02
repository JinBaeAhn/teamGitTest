package semi.team.baro.uploadImage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet(name = "UploadImage", urlPatterns = { "/uploadImage.do" })
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//경로설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/editor" ;
		//최대 사이즈 지정
		int maxSize = 10 * 1024 * 1024;
		//파일 업로드
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String filePath = multipartRequest.getFilesystemName("file");
		//결과처리 > 업로드 된 파일 경로 리턴하면 됨
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//image태그 SRC속성에 넣을 값 그대로 리턴하는 중 
		out.print("/upload/editor/" + filePath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

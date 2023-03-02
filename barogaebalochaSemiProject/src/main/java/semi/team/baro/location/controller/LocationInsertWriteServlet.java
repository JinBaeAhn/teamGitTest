package semi.team.baro.location.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.team.baro.location.model.vo.Location;

/**
 * Servlet implementation class LocationInsertWriteServlet
 */
@WebServlet(name = "LocationInsertWrite", urlPatterns = { "/locationInsertWrite.do" })
public class LocationInsertWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationInsertWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/location";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request,saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		String groundName = mRequest.getParameter("groundName");
		String groundLat = mRequest.getParameter("groundLat");
		String groundLng = mRequest.getParameter("groundLng");
		String groundContent = mRequest.getParameter("groundContent");
		String filename = mRequest.getOriginalFileName("upfile");
		Location l = new Location();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

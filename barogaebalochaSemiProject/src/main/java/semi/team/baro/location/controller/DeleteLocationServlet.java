package semi.team.baro.location.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.location.model.service.LocationService;
import semi.team.baro.location.model.vo.Location;

/**
 * Servlet implementation class DeleteLocationServlet
 */
@WebServlet(name = "DeleteLocation", urlPatterns = { "/deleteLocation.do" })
public class DeleteLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLocationServlet() {
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
		int groundNo = Integer.parseInt(request.getParameter("groundNo"));
		//3. 비즈니스로직
		LocationService service = new LocationService();
		Location l = service.deleteLocation(groundNo);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(l !=null) {
			//게시글삭제에 성공하면 첨부파일이 있는지 확인한 후 
			//첨부파일이 있으면 삭제
			if(l.getFilePath()!=null) {
				String root = getServletContext().getRealPath("/");
				String deleteFile = root+"upload/location/"+l.getFilePath();
				File delFile = new File(deleteFile);
				delFile.delete();//파일삭제코드
			}
			request.setAttribute("title", "삭제성공");
			request.setAttribute("msg", "게시글이 삭제되었습니다");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/LocationList.do?reqPage=1");
		}else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/locationInfo.do?groundNo="+groundNo);
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

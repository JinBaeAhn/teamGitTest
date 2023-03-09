package semi.team.baro.location.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.location.model.service.LocationService;
import semi.team.baro.location.model.vo.LocationViewData;

/**
 * Servlet implementation class LocationInfoServlet
 */
@WebServlet(name = "LocationInfo", urlPatterns = { "/locationInfo.do" })
public class LocationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int groundNo = Integer.parseInt(request.getParameter("groundNo"));
		//3.비즈니스로직
		LocationService service = new LocationService();
		LocationViewData lvd = service.selectOneLocation(groundNo);
		//System.out.println("그라운드넘버 테스트 아아"+lvd.getL().getGroundNo());
		//System.out.println("그라운드넘버 테스트 아아"+groundNo);
		if(lvd == null) { //실패했을 때
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "오류가 발생했습니다");
			request.setAttribute("msg", "다시 시도해주세요. 계속 문제가 발생한다면 관리자에게 문의해주세요.");
			request.setAttribute("icon", "info");
			request.setAttribute("loc","/locationList.do?requestPage=1");
			view.forward(request, response);
		}else {//성공했을 때 상세페이지
			RequestDispatcher view = request.getRequestDispatcher( "/WEB-INF/views/location/locationInfo.jsp" );
			request.setAttribute("l", lvd.getL());
			view.forward(request, response);
		}
		//4.화면처리
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

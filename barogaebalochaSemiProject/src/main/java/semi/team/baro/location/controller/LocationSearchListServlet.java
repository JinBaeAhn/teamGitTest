package semi.team.baro.location.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import semi.team.baro.location.model.service.LocationService;
import semi.team.baro.location.model.vo.Location;

/**
 * Servlet implementation class LocationSearchListServlet
 */
@WebServlet(name = "LocationSearchList", urlPatterns = { "/locationSearchList.do" })
public class LocationSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationSearchListServlet() {
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
		String location = request.getParameter("groundLocation");
		
		//3.비즈니스로직
		//System.out.println("지역"+location);
		LocationService service = new LocationService();
		ArrayList<Location> list = service.locationSearchList(location);
		
		//System.out.println("리스트사이즈 잘 나오냐"+list.size());
		JSONArray locationSearchList = new JSONArray();
		
		if(!list.isEmpty()) {
			for(Location l : list) {
				JSONObject obj = new JSONObject();
				obj.put("groundName", l.getGroundName());
				obj.put("groundPrice", l.getGroundPrice());
				locationSearchList.add(obj);
			}
		}
		//4.결과처리
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(locationSearchList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

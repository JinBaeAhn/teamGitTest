package semi.team.baro.matching.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.location.model.service.LocationService;
import semi.team.baro.location.model.vo.LocationViewData;
import semi.team.baro.matching.model.service.MatchingService;
import semi.team.baro.matching.model.vo.Matching;
import semi.team.baro.matching.model.vo.MatchingMemberCheck;
import semi.team.baro.matching.model.vo.MatchingViewData;

/**
 * Servlet implementation class MatchingViewServlet
 */
@WebServlet(name = "MatchingView", urlPatterns = { "/matchingView.do" })
public class MatchingViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingViewServlet() {
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
		//System.out.println("여까진 돌아감?");
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		//System.out.println("멤버넘버 잘 냐오냐?"+memberNo);
		int matchingBoardNo = Integer.parseInt(request.getParameter("matchingBoardNo"));
		//System.out.println("test용 레저브"+reservationNo);
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		//Matching mc = service.selectOneMatch(matchingBoardNo);
		MatchingMemberCheck mmc = service.selectOneMatch(reservationNo, matchingBoardNo, memberNo);
		//System.out.println("멤버체크 확인"+mmc.getMemberCheck());
		
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/matching/matchingView.jsp");
		request.setAttribute("mc", mmc.getMc());
		request.setAttribute("check", mmc.getMemberCheck());
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

package semi.team.baro.matching.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.matching.model.vo.Matching;

/**
 * Servlet implementation class MatchingListInsertServlet
 */
@WebServlet(name = "MatchingListInsert", urlPatterns = { "/matchingListInsert.do" })
public class MatchingListInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingListInsertServlet() {
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
		Matching mc = new Matching();
		mc.setGroundLocation(request.getParameter("groundLocation"));
		mc.setReservationTime(request.getParameter("reservationTime"));
		mc.setReservationDate(request.getParameter("reservationDate"));
		mc.setGroundName(request.getParameter("groundName"));
		mc.setReservationNo(Integer.parseInt(request.getParameter("reservationNo")));
		mc.setMatchingStatus(Integer.parseInt(request.getParameter("matchingStatus")));
		mc.setMatchingBoardContent(request.getParameter("matchingBoardContent"));
		mc.setMatchingBoardTitle(request.getParameter("matchingTitle"));
		//3.비즈니스로직
		//4.결과처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

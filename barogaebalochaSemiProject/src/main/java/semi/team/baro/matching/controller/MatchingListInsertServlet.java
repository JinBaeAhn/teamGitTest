package semi.team.baro.matching.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.matching.model.service.MatchingService;
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
		mc.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		mc.setGroundLocation(request.getParameter("groundLocation"));
		mc.setReservationTime(Integer.parseInt(request.getParameter("reservationTime")));
		mc.setReservationDate(request.getParameter("reservationDate"));
		mc.setGroundName(request.getParameter("groundName"));
		//System.out.println(mc.getGroundName()+"구장이름");
		//mc.setReservationNo(Integer.parseInt(request.getParameter("reservationNo")));
		//mc.setMatchingStatus(Integer.parseInt(request.getParameter("matchingStatus")));
		mc.setMatchingBoardContent(request.getParameter("matchingBoardContent"));
		mc.setMatchingBoardTitle(request.getParameter("matchingBoardTitle"));
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		int result = service.matchingListInsert(mc);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("icon", "success");
			request.setAttribute("title", "작성완료");
			request.setAttribute("msg", "매칭글이 작성되었습니다.");
		}else {
			request.setAttribute("icon", "error");
			request.setAttribute("title", "작성실패");
			request.setAttribute("msg", "오류가 발생했습니다.");
		}
		request.setAttribute("loc", "/matchingList.do?requestPage=1");
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

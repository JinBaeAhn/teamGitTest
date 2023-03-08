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
 * Servlet implementation class MatchingMemberListInsertServlet
 */
@WebServlet(name = "MatchingMemberListInsert", urlPatterns = { "/matchingMemberListInsert.do" })
public class MatchingMemberListInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingMemberListInsertServlet() {
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
		int matchingBoardNo = Integer.parseInt(request.getParameter("matchingBoardNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		int result = service.matchingMemberInsert(matchingBoardNo, memberNo);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "매칭신청완료");
			request.setAttribute("msg", "매치신청이 완료되었습니다");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "매칭신청실패");
			request.setAttribute("msg", "매치신청 중 오류가 발생했습니다");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/matchingView.do?reservationNo="+reservationNo);
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

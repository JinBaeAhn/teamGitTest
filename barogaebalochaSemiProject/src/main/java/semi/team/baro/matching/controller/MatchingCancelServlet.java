package semi.team.baro.matching.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.matching.model.service.MatchingService;

/**
 * Servlet implementation class MatchingCancelServlet
 */
@WebServlet(name = "MatchingCancel", urlPatterns = { "/matchingCancel.do" })
public class MatchingCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingCancelServlet() {
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
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int groundPrice = Integer.parseInt(request.getParameter("groundPrice"));
		int memberCredit = Integer.parseInt(request.getParameter("memberCredit"));
		//System.out.println("돈체크"+memberCredit);
		int matchingBoardNo = Integer.parseInt(request.getParameter("matchingBoardNo"));
		//System.out.println("체크체크"+matchingBoardNo);
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		
		int sum = groundPrice+memberCredit;
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		int statusResult = service.MatchingCancel(memberNo, sum, matchingBoardNo);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(statusResult > 0) {
			request.setAttribute("icon", "success");
			request.setAttribute("title", "매치취소완료");
			request.setAttribute("msg", "매치가 취소와 동시에 포인트 환불 완료되었습니다");
		}else {
			request.setAttribute("icon", "error");
			request.setAttribute("title", "매치취소실패");
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

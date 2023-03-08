package semi.team.baro.matching.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.matching.model.service.MatchingService;
import semi.team.baro.matching.model.vo.MatchingPageData;

/**
 * Servlet implementation class MatchingMemberListServlet
 */
@WebServlet(name = "MatchingMemberList", urlPatterns = { "/matchingMemberList.do" })
public class MatchingMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingMemberListServlet() {
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
		System.out.println(matchingBoardNo);
		int reqPage = Integer.parseInt(request.getParameter("requestPage"));
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		MatchingPageData mpd = service.MatchingMemberList(matchingBoardNo, reqPage);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/matching/matchingMemberList.jsp");
		request.setAttribute("list", mpd.getList());
		request.setAttribute("pageNavi", mpd.getPageNavi());
		request.setAttribute("start", mpd.getStart());
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

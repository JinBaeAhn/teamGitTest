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
import semi.team.baro.matching.model.vo.MatchingPageData;

/**
 * Servlet implementation class MatchingListServlet
 */
@WebServlet(name = "MatchingList", urlPatterns = { "/matchingList.do" })
public class MatchingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchingListServlet() {
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
		//System.out.println("dddddd");
		int reqPage = Integer.parseInt(request.getParameter("requestPage"));
		//System.out.println(reqPage);
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		MatchingPageData mpd = service.selectMatchingList(reqPage);
		//System.out.println("매칭리스트 리스트사이즈"+mpd.getList().size());
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/matching/matchingList.jsp");
		request.setAttribute("list", mpd.getList());
		//System.out.println("매칭리스트 그라운드넘버"+mpd.getList().get(4).getGroundName());
		//System.out.println("매칭리스트 그라운드지역"+mpd.getList().get(0).getGroundLocation());
		/*
		for(Matching m : mpd.getList()) {
			System.out.println(m.getMatchingBoardTitle());
		}
		*/
		//System.out.println(mpd.getList().size());
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

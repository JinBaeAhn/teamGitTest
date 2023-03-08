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
 * Servlet implementation class ApplyInsertServlet
 */
@WebServlet(name = "ApplyInsert", urlPatterns = { "/applyInsert.do" })
public class ApplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyInsertServlet() {
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
		int matchingBoardNo = Integer.parseInt(request.getParameter("matchingBoardNo"));
		//System.out.println("매칭보드넘버 테스트"+matchingBoardNo);
		//3.비즈니스로직
		MatchingService service = new MatchingService();
		int result = service.applyInsert(memberNo, matchingBoardNo);
		//4.화면처리
		System.out.println("msg before");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("icon", "success");
			request.setAttribute("title", "수락완료");
			request.setAttribute("msg", "신청을 수락했습니다. 회원님께 연락해주세요");
		}else {
			request.setAttribute("icon", "error");
			request.setAttribute("title", "수락실패");
			request.setAttribute("msg", "오류가 발생했습니다.");
		}
		request.setAttribute("loc", "matchingMemberList.do?matchingBoardNo="+matchingBoardNo+"&requestPage=1");
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

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
 * Servlet implementation class ApplyCancelServlet
 */
@WebServlet(name = "ApplyCancel", urlPatterns = { "/applyCancel.do" })
public class ApplyCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyCancelServlet() {
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
				int result = service.applyCancel(memberNo, matchingBoardNo);
				//4.화면처리
				System.out.println("msg before");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(result > 0) {
					request.setAttribute("icon", "success");
					request.setAttribute("title", "요청성공");
					request.setAttribute("msg", "정상적으로 수락이 취소되었습니다.");
				}else {
					request.setAttribute("icon", "error");
					request.setAttribute("title", "요청실패");
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

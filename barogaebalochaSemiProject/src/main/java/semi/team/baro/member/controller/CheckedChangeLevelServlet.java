package semi.team.baro.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.member.model.service.MemberService;

/**
 * Servlet implementation class CheckedChangeLevelServlet
 */
@WebServlet(name = "CheckedChangeLevel", urlPatterns = { "/checkedChangeLevel.do" })
public class CheckedChangeLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckedChangeLevelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String no = request.getParameter("no");
		String level = request.getParameter("level");
		//3. 비즈니스로직
		MemberService service = new MemberService();
		boolean result = service.checkedChangeLevel(no, level);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result) {
			if(result) {
				request.setAttribute("title", "정보변경 성공");
				request.setAttribute("msg", "요청이 처리되었습니다.");
				request.setAttribute("icon", "success");
			}else {
				request.setAttribute("title", "정보변경 실패");
				request.setAttribute("msg", "요청 처리중 문제가 발생했습니다.");
				request.setAttribute("icon", "error");
			}
			request.setAttribute("loc", "/adminPage.do?reqPage=1");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

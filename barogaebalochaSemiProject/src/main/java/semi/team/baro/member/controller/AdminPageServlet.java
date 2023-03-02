package semi.team.baro.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.team.baro.member.model.service.MemberService;
import semi.team.baro.member.model.vo.Member;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet(name = "AdminPage", urlPatterns = { "/adminPage.do" })
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
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
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		
		if(m !=null) {
			//로그인 된 경우
			if(m.getMemberLevel() !=1) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				request.setAttribute("title", "????????");
				request.setAttribute("msg", "관리자만 이용 가능합니다.");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc", "/");
				view.forward(request, response);
				return;
			}
		}else {
			//로그인 안된경우
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "접근제한");
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			request.setAttribute("icon", "info");
			request.setAttribute("loc", "/");
			view.forward(request, response);
			return;
		}
		//3.비즈니스 로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		//화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/adminPage.jsp");
		request.setAttribute("list", list);
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

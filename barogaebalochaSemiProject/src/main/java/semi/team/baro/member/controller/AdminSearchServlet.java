package semi.team.baro.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AdminSearchServlet
 */
@WebServlet(name = "AdminSearch", urlPatterns = { "/adminSearch.do" })
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchServlet() {
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
		String memberId = request.getParameter("memberId");
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
		//3. 비즈니스로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.adminselectAllMember(memberId);
		
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/adminSearchPage.jsp");
		request.setAttribute("list", list);
		System.out.println(list.size());
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

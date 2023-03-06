package semi.team.baro.member.controller;

import java.io.IOException;

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
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "deleteMember", urlPatterns = { "/deleteMember.do" })
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		
		MemberService service = new MemberService();
		int result = service.deleteMember(m);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result >0 ) {
			request.setAttribute("title", "탈퇴 성공");
			request.setAttribute("msg", "Bye~");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/logout.do");
			
		}else {
			request.setAttribute("title", "탈퇴 실패");
			request.setAttribute("msg", "넌 못간다");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/mypage.do");
		}
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

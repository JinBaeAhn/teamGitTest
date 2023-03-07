package semi.team.baro.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.member.model.service.MemberService;
import semi.team.baro.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberCreditServlet
 */
@WebServlet(name = "updateMemberCredit", urlPatterns = { "/updateMemberCredit.do" })
public class UpdateMemberCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		int newMemberCredit = Integer.parseInt(request.getParameter("newMemberCredit"));
		int memberCredit = Integer.parseInt(request.getParameter("memberCredit"));
		int totalCredit = newMemberCredit + memberCredit;
		
		MemberService service = new MemberService();
		int result = service.updateMemberCredit(memberId, totalCredit);

		if(result>0) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp");
			request.setAttribute("memberCredit", totalCredit);
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "포인트적립실패");
			request.setAttribute("msg", "관리자에게 문의해주세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/WEB-INF/views/member/mypage.jsp");
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

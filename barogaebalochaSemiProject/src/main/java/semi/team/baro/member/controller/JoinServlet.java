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
 * Servlet implementation class JoinServlet
 */
@WebServlet(name = "Join", urlPatterns = { "/join.do" })
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setMemberMail(request.getParameter("memberMail1")+"@"+request.getParameter("memberMail2"));
		m.setMemberPhone(request.getParameter("memberPhone1")+"-"+request.getParameter("memberPhone2")+"-"+request.getParameter("memberPhone3"));
		m.setMemberContent(request.getParameter("memberContent"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		m.setFilepath(request.getParameter("filepath"));
		//3.비즈니스로직
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		MemberService service = new MemberService();
		int result = service.insertMember(m);
		//4.결과처리
		if(result > 0) {
			request.setAttribute("title", "회원가입 성공");
			request.setAttribute("msg", "회원가입을 환영합니다");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/");
		}else {
			request.setAttribute("title", "회원가입 실패");
			request.setAttribute("msg", "가입정보를 확인하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
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

package semi.team.baro.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.member.model.service.MemberService;
import semi.team.baro.member.model.vo.Member;

/**
 * Servlet implementation class PasswordSendServlet
 */
@WebServlet(name = "passwordSend", urlPatterns = { "/passwordSend.do" })
public class PasswordSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPhone = request.getParameter("memberPhone");
		String memberMail = request.getParameter("memberMail");
		
		MemberService service = new MemberService();
		Member m = service.selectOneMember(memberId, memberPhone, memberMail);
		
		MailSender2 sender = new MailSender2();
		PrintWriter out = response.getWriter();
		if(m != null) {
			String randomCode = sender.sendMail(memberMail);
			int result = service.updateMember(memberId, randomCode);
			if(result>0) {
				out.print(randomCode);				
			}else {
				out.print(0);				
			}
		}else {
			out.print(0);
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

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
 * Servlet implementation class CheckIdServlet
 */
@WebServlet(name = "checkId", urlPatterns = { "/checkId.do" })
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		
		MemberService service = new MemberService();
		
		Member m = service.selectOneMember(memberName, memberPhone);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(m !=null) {
			out.print(m.getMemberId());
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

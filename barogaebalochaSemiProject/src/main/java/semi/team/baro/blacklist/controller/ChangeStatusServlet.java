package semi.team.baro.blacklist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.blacklist.model.service.BlacklistService;

/**
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet(name = "ChangeStatus", urlPatterns = { "/changeStatus.do" })
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
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
		int blackNo = Integer.parseInt(request.getParameter("blackNo"));
		int blackStatus = Integer.parseInt(request.getParameter("blackStatus"));
		System.out.println("blackrNo : " + blackNo);
		System.out.println("blackStatus : " + blackStatus);
		//3.비즈니스로직
		BlacklistService service = new BlacklistService();
		int result = service.changeStatus(blackNo,blackStatus);
		//4. 결과처리
		// 변경성공 : 관리자페이지로 이동
		// 변경실패 : alert메세지 띄운 후 관리자페이지로 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			//주소창을 변경
			request.setAttribute("title", "상태 변경 성공");
			request.setAttribute("msg", "상태 변경 완료");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/adminBlacklistList.do?reqPage=1");
		}else {
			request.setAttribute("title", "등급 변경 실패");
			request.setAttribute("msg", "등급 변경 중 문제가 발생");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/adminBlacklistList.do?reqPage=1");
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

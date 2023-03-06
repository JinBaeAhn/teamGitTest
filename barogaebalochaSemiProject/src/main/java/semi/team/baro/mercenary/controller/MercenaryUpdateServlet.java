package semi.team.baro.mercenary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.mercenary.model.service.MercenaryService;
import semi.team.baro.mercenary.model.vo.Mercenary;

/**
 * Servlet implementation class MercenaryUpdateServlet
 */
@WebServlet(name = "MercenaryUpdate", urlPatterns = { "/mercenaryUpdate.do" })
public class MercenaryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercenaryUpdateServlet() {
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
		//지역, 경기장, 경기날짜, 경기시간, 실력, 참가비, 내용 , 게시글번호
		Mercenary mc = new Mercenary();
		mc.setLocation(request.getParameter("location"));
		mc.setGroundName(request.getParameter("groundName"));
		mc.setGameDate(request.getParameter("gameDate"));
		mc.setGameTime(Integer.parseInt(request.getParameter("gameTime")));
		mc.setLevel(Integer.parseInt(request.getParameter("level")));
		mc.setMercenaryPay(Integer.parseInt(request.getParameter("mercenaryPay")));
		mc.setMercenaryContent(request.getParameter("mercenaryContent"));
		mc.setMercenaryNo(Integer.parseInt(request.getParameter("mercenaryNo")));
		//3. 비즈니스로직
		MercenaryService service = new MercenaryService();
		int result = service.mercenaryUpdate(mc);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "수정완료");
			request.setAttribute("msg", "게시글 수정이 완료되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "ERROR");
			request.setAttribute("msg", "알 수 없는 오류가 발생했습니다. 관리자에게 문의하세요.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/mercenaryView.do?mercenaryNo="+mc.getMercenaryNo());
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

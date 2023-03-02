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
 * Servlet implementation class MercenaryInsertServlet
 */
@WebServlet(name = "MercenaryInsert", urlPatterns = { "/mercenaryInsert.do" })
public class MercenaryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercenaryInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출 - 지역 / 경기장 / 경기날짜 / 경기시간 / 실력 / 참가비 / 게시글내용
		Mercenary m = new Mercenary();	
		m.setLocation(request.getParameter("location"));
		m.setGroundName(request.getParameter("groundName"));
		m.setGameDate(request.getParameter("gameDate"));
		m.setGameTime(request.getParameter("gameTime"));
		m.setLevel(Integer.parseInt(request.getParameter("level")));
		m.setMercenaryPay(Integer.parseInt(request.getParameter("mercenaryPay")));
		m.setMercenaryContent(request.getParameter("mercenaryContent"));
		System.out.println(m.getLocation()+m.getGroundName()+m.getGameDate()+m.getGameTime()+m.getLevel()+m.getMercenaryPay()+m.getMercenaryContent());
		//3. 비즈니스로직
		MercenaryService service = new MercenaryService();
		int result = service.mercenaryInsert(m);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("icon", "success");
			request.setAttribute("title", "작성완료");
			request.setAttribute("msg", "게시글이 작성되었습니다.");
			request.setAttribute("loc", "/mercenaryList.do");
		}else {
			request.setAttribute("icon", "error");
			request.setAttribute("title", "작성완료");
			request.setAttribute("msg", "오류가 발생했습니다.");
			request.setAttribute("loc", "/mercenaryList.do");
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

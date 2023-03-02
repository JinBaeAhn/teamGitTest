package semi.team.baro.mercenary.controller;

import java.io.IOException;
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
		//2. 값추출 - 지역 / 경기장 / 경기날짜 / 경기시간 / 실력 / 참가비
		Mercenary m = new Mercenary();
		
		m.setLocation(request.getParameter("location"));
		m.setGroundName(request.getParameter("groundName"));
		m.setGameDate(request.getParameter("gameDate"));
		m.setGameTime(request.getParameter("gameTime"));
		m.setLevel(Integer.parseInt(request.getParameter("level")));
		m.setPay(Integer.parseInt(request.getParameter("pay")));
		
		MercenaryService service = new MercenaryService();
		int result = service.mercenaryInsert(m);
		//3. 비즈니스로직
		//4. 결과처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

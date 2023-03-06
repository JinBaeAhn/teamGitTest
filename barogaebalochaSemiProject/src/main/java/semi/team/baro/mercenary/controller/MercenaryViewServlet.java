package semi.team.baro.mercenary.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.mercenary.model.service.MercenaryService;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

/**
 * Servlet implementation class MercenaryViewServlet
 */
@WebServlet(name = "MercenaryView", urlPatterns = { "/mercenaryView.do" })
public class MercenaryViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercenaryViewServlet() {
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
		int mercenaryNo = Integer.parseInt(request.getParameter("mercenaryNo"));
		//3.비즈니스로직
		MercenaryService service = new MercenaryService();
		Mercenary mc = service.mercenaryView(mercenaryNo);
		ArrayList<MercenaryRequest> list = service.mercenaryRequestList(mercenaryNo); //댓글리스트
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mercenary/mercenaryView.jsp");
		request.setAttribute("mc", mc);
		request.setAttribute("list", list);
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

package semi.team.baro.blacklist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.blacklist.model.service.BlacklistService;
import semi.team.baro.blacklist.model.vo.Blacklist;

/**
 * Servlet implementation class BlacklistVIewServlet
 */
@WebServlet(name = "BlacklistVIew", urlPatterns = { "/blacklistVIew.do" })
public class BlacklistVIewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlacklistVIewServlet() {
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
		//3. 비즈니스로직
		BlacklistService service = new BlacklistService();
		Blacklist bla = service.blacklistView(blackNo);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/blacklist/blacklistView.jsp");
		request.setAttribute("bla", bla);
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

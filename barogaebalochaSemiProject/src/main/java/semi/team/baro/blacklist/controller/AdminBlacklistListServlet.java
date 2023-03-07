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
import semi.team.baro.blacklist.model.vo.BlacklistPageData;

/**
 * Servlet implementation class AdminBlacklistListServlet
 */
@WebServlet(name = "AdminBlacklistList", urlPatterns = { "/adminBlacklistList.do" })
public class AdminBlacklistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlacklistListServlet() {
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
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3.비즈니스로직
		BlacklistService service = new BlacklistService();
		BlacklistPageData bl = service.adminBlacklistList(reqPage);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/blacklist/adminBlacklistList.jsp");
		request.setAttribute("list", bl.getList());
		request.setAttribute("pageNavi", bl.getPageNavi());
		request.setAttribute("start", bl.getStart());
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

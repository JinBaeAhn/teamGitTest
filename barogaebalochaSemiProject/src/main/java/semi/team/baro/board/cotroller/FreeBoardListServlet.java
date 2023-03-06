package semi.team.baro.board.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.board.model.service.BoardService;
import semi.team.baro.board.model.vo.BoardPageData;
import semi.team.baro.notice.model.vo.Notice;

/**
 * Servlet implementation class FreeBoardListServlet
 */
@WebServlet(name = "FreeBoardList", urlPatterns = { "/freeBoardList.do" })
public class FreeBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		int boardPage = Integer.parseInt(request.getParameter("boardPage"));
		BoardService boardService = new BoardService();
		BoardPageData boardPageData = boardService.selectBoardList(boardPage);
		request.setAttribute("boardList", boardPageData.getBoardList());
		request.setAttribute("pageNavigation", boardPageData.getPageNavigation());
		request.setAttribute("start", boardPageData.getStart());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/board/freeBoardList.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

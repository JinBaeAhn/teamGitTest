package semi.team.baro.board.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.board.model.service.BoardService;
import semi.team.baro.board.model.vo.Board;

/**
 * Servlet implementation class FreeBoardViewServlet
 */
@WebServlet(name = "FreeBoardView", urlPatterns = { "/freeBoardView.do" })
public class FreeBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int photoNo = Integer.parseInt(request.getParameter("photoNo"));
		BoardService BoardService = new BoardService();
		Board board = BoardService.selectOneBoard(photoNo);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/board/freeBoardView.jsp");
		request.setAttribute("board", board);
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

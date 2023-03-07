package semi.team.baro.board.cotroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.board.model.service.BoardService;
import semi.team.baro.board.model.vo.Board;

/**
 * Servlet implementation class RemoveFreeBoardServlet
 */
@WebServlet(name = "RemoveFreeBoard", urlPatterns = { "/removeFreeBoard.do" })
public class RemoveFreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFreeBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int photoNo = Integer.parseInt(request.getParameter("photoNo"));
		BoardService boardService = new BoardService();
		Board board = boardService.removeBoard(photoNo);
		if(board.getFilepath() != null) {
			String root = getServletContext().getRealPath("/");
			String removeFileRoot = root+"upload/board/"+board.getFilepath();
			File removeFile = new File(removeFileRoot);
			removeFile.delete();
		}
		response.sendRedirect("freeBoardList.do?boardPage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

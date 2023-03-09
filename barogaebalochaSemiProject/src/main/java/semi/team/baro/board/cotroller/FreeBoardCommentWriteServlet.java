package semi.team.baro.board.cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.team.baro.board.model.service.BoardService;
import semi.team.baro.board.model.vo.BoardComment;

/**
 * Servlet implementation class FreeBoardCommentWriteServlet
 */
@WebServlet(name = "FreeBoardCommentWrite", urlPatterns = { "/freeBoardCommentWrite.do" })
public class FreeBoardCommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardCommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String boardCommentContent = request.getParameter("boardCommentContent");
		int boardCommentReference = Integer.parseInt(request.getParameter("boardCommentReference"));
		int boardCommentWriter = Integer.parseInt(request.getParameter("boardCommentWriter"));
		int boardCommentSelfReference = Integer.parseInt(request.getParameter("boardCommentSelfReference"));
		BoardComment boardComment = new BoardComment(boardCommentReference, boardCommentWriter, boardCommentContent, boardCommentSelfReference);
		int result = new BoardService().freeBoardCommentWrite(boardComment);
		if(result > 0) {
			System.out.println("댓글 작성 성공");
		}
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		gson.toJson(result, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

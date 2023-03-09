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
 * Servlet implementation class FreeBoardCommentUpdateServlet
 */
@WebServlet(name = "FreeBoardCommentUpdate", urlPatterns = { "/freeBoardCommentUpdate.do" })
public class FreeBoardCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String modifyCommentContent = request.getParameter("modifyCommentContent");
		int updateBoardCommentReference = Integer.parseInt(request.getParameter("updateBoardCommentReference"));
		int updateBoardCommentWriter = Integer.parseInt(request.getParameter("updateBoardCommentWriter"));
		int updateBoardCommentSelfReference = Integer.parseInt(request.getParameter("updateBoardCommentSelfReference"));
		int modifyMyNo = Integer.parseInt(request.getParameter("modifyMyNo"));
		BoardComment boardComment = new BoardComment(modifyMyNo,updateBoardCommentReference, updateBoardCommentWriter, modifyCommentContent, updateBoardCommentSelfReference);
		int result = new BoardService().freeBoardCommentUpdate(boardComment);
		if(result > 0) {
			System.out.println("댓글 수정 성공");
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

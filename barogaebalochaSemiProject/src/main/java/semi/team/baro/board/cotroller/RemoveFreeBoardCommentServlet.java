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

/**
 * Servlet implementation class RemoveFreeBoardCommentServlet
 */
@WebServlet(name = "RemoveFreeBoardComment", urlPatterns = { "/removeFreeBoardComment.do" })
public class RemoveFreeBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFreeBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardCommentNo =  Integer.parseInt(request.getParameter("boardCommentNo"));
		int result = new BoardService().removeFreeBoardComment(boardCommentNo);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		gson.toJson(result,out);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

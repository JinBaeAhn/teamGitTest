package semi.team.baro.board.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.team.baro.board.model.service.BoardService;
import semi.team.baro.board.model.vo.Board;

/**
 * Servlet implementation class FreeBoardWriteServlet
 */
@WebServlet(name = "FreeBoardWrite", urlPatterns = { "/freeBoardWrite.do" })
public class FreeBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/board";
		int maxSize = 10*1024*1024;
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String boardTitle = multipartRequest.getParameter("boardTitle");
		int memberNo = Integer.parseInt(multipartRequest.getParameter("memberNo"));
		String boardContent = multipartRequest.getParameter("boardContent");
		//filename
		String filename = multipartRequest.getOriginalFileName("upFile");
		//filepath
		String filepath = multipartRequest.getFilesystemName("upFile");
		Board board = new Board();
		board.setFilename(filename);
		board.setFilepath(filepath);
		board.setPhotoTitle(boardTitle);
		board.setPhotoContent(boardContent);
		board.setMemberNo(memberNo);
		BoardService boardService = new BoardService();
		int result = boardService.insertBoard(board);
		if(result > 0) {
			System.out.println("자유게시판 게시글 작성 성공");
		} else {
			System.out.println("자유게시판 게시글 작성 실패");
		}
		response.sendRedirect("/freeBoardList.do?boardPage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

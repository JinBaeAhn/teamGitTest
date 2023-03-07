package semi.team.baro.board.cotroller;

import java.io.File;
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
 * Servlet implementation class FreeBoardUpdateServlet
 */
@WebServlet(name = "FreeBoardUpdate", urlPatterns = { "/freeBoardUpdate.do" })
public class FreeBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardUpdateServlet() {
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
		int photoNo = Integer.parseInt(multipartRequest.getParameter("photoNo"));
		String photoTitle = multipartRequest.getParameter("photoTitle");
		String photoContent = multipartRequest.getParameter("photoContent");
		//기존파일 삭제시 delete 아니면 stay
		String status = multipartRequest.getParameter("status");
		//새 첨부파일이 있으면 새 파일 값, 없으면 NULL.
		String filename = multipartRequest.getOriginalFileName("upFile");
		String filepath = multipartRequest.getFilesystemName("upFile");
		//기존 첨부파일 잇었으면 기존첨부파일 이름,패스 없었으면 null
		String oldFilename = multipartRequest.getParameter("oldFilename");
		String oldFilepath = multipartRequest.getParameter("oldFilepath");
		
		if(oldFilename != null && status.equals("stay")) {
			filename = oldFilename;
			filepath = oldFilepath;
		}
		Board board = new Board(photoNo,photoTitle,photoContent,filename,filepath);
		BoardService boardService= new BoardService();
		int result = boardService.updateBoard(board);
		if(result > 0) {
			System.out.println("파일 업데이트 성공");
		} else {
			System.out.println("파일 업데이트 실패");
		}
		if(result > 0 && status.equals("delete")) {
			File deleteFile = new File(saveDirectory+"/"+oldFilepath);
			deleteFile.delete();
		}
		response.sendRedirect("/freeBoardView.do?photoNo="+photoNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

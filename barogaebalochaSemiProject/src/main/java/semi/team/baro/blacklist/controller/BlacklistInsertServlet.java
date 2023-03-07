package semi.team.baro.blacklist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.team.baro.blacklist.model.service.BlacklistService;
import semi.team.baro.blacklist.model.vo.Blacklist;

/**
 * Servlet implementation class BlacklistInsertServlet
 */
@WebServlet(name = "BlacklistInsert", urlPatterns = { "/blacklistInsert.do" })
public class BlacklistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlacklistInsertServlet() {
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
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/blacklist";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		String blackTitle = mRequest.getParameter("blackTitle");
		int writeMemberNo = Integer.parseInt(mRequest.getParameter("writeMemberNo"));
		String blackMemberId = mRequest.getParameter("blackMember");
		String filepath = mRequest.getFilesystemName("upfile");
		String blackContent = mRequest.getParameter("blackContent");
		Blacklist bl = new Blacklist();
		bl.setBlackTitle(blackTitle);
		bl.setMemberNo(writeMemberNo);
		bl.setMemberId(blackMemberId);
		bl.setBlackFilepath(filepath);
		bl.setBlackContent(blackContent);
		System.out.println("확인");
		System.out.println(blackTitle+"/"+writeMemberNo+"/"+blackMemberId+"/"+filepath+"/"+blackContent);
		//3. 비즈니스로직
		BlacklistService service = new BlacklistService();
		int result = service.blacklistInsert(bl);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "작성완료");
			request.setAttribute("msg", "신고글을 정상적으로 작성하였습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/historyMercenaryRequest.do?memberNo="+writeMemberNo+"&reqPage=1&categoryName=mercenaryRequest");
		}else {
			request.setAttribute("title", "ERROR");
			request.setAttribute("msg", "알 수 없는 오류가 발생했습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/blackListFrm.do");
		}
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

package semi.team.baro.mercenary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.mercenary.model.service.MercenaryService;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

/**
 * Servlet implementation class MercenaryCommentInsertServlet
 */
@WebServlet(name = "MercenaryRequestInsert", urlPatterns = { "/mercenaryRequestInsert.do" })
public class MercenaryRequestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercenaryRequestInsertServlet() {
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
		MercenaryRequest mcReq = new MercenaryRequest();
		mcReq.setMercenaryNo(Integer.parseInt(request.getParameter("mercenaryNo")));
		mcReq.setMemberNo(Integer.parseInt(request.getParameter("mcRequsetWriter")));
		mcReq.setMercenaryRequestContent(request.getParameter("mcRequestContent"));
		//3. 비즈니스로직
		MercenaryService service = new MercenaryService();
		int result = service.mercenaryRequestInsert(mcReq);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "용병 신청 성공");
			request.setAttribute("msg", "용병신청에 성공했습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "용병 신청 실패");
			request.setAttribute("msg", "에러가 발생했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/mercenaryView.do?mercenaryNo="+request.getParameter("mercenaryNo"));
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

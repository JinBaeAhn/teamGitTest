package semi.team.baro.mercenary.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.team.baro.mercenary.model.service.MercenaryService;

/**
 * Servlet implementation class DeleteMercenaryRequestServlet
 */
@WebServlet(name = "DeleteMercenaryRequest", urlPatterns = { "/deleteMercenaryRequest.do" })
public class DeleteMercenaryRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMercenaryRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출 - mcReqNo, mercenaryNo
		int mcReqNo = Integer.parseInt(request.getParameter("mcReqNo"));
		int mercenaryNo = Integer.parseInt(request.getParameter("mercenaryNo"));
		//3. 비즈니스로직
		MercenaryService service = new MercenaryService();
		int result = service.mercenaryRequestDelete(mcReqNo, mercenaryNo);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "삭제성공");
			request.setAttribute("msg", "용병신청을 취소했습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "처리 중 오류가 발생했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/mercenaryView.do?mercenaryNo="+mercenaryNo);
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

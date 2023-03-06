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
 * Servlet implementation class MercenarySelServlet
 */
@WebServlet(name = "MercenarySel", urlPatterns = { "/mercenarySel.do" })
public class MercenarySelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercenarySelServlet() {
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
		int mcReqNo = Integer.parseInt(request.getParameter("mcReqNo"));
		int mercenaryNo = Integer.parseInt(request.getParameter("mercenaryNo"));
		String mcReqWriter = request.getParameter("mcReqWriter");
		MercenaryRequest mcReq = new MercenaryRequest();
		mcReq.setMercenaryRequestNo(mcReqNo);
		mcReq.setMercenaryNo(mercenaryNo);
		mcReq.setMemberId(mcReqWriter);
		//3. 비즈니스로직
		MercenaryService service = new MercenaryService();
		int result = service.mercenarySel(mcReq);
		//mercenary_request 테이블의 mercenary_request_result를 전부 1로변경(where mercenaryNo = ?)에 해당하는것만
		//mercenary_request 테이블의 mercenary_request_result를 해당 request를 작성한 아이디로 update
		//mercenary 테이블의 mercenaryWhether를 0에서 1로변경(모집중 -> 모집완료)
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "용병선택을 완료했습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "실패");
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

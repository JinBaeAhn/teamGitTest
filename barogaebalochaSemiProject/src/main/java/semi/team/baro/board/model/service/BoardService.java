package semi.team.baro.board.model.service;

import semi.team.baro.board.model.dao.BoardDao;
import semi.team.baro.board.model.vo.BoardPageData;
import semi.team.baro.notice.model.service.NoticeService;

public class BoardService extends NoticeService {
	BoardDao boardDao;

	public BoardService() {
		super();
		boardDao = new BoardDao();
	}

	public BoardPageData selectBoardList(int boardPage) {
		
		return null;
	}
	
}
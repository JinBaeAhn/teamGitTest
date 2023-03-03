package semi.team.baro.matching.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import semi.team.baro.matching.model.dao.MatchingDao;
import semi.team.baro.matching.model.vo.MatchingPageData;

public class MatchingService {
	private MatchingDao dao;

	public MatchingService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchingPageData selectMatchingList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//1.페이지당 게시물은 10개
		int numPerPage = 10;
		//1.요청페이지 1페이지 -> 최신글 1~10
		//2페이지 -> 11~20
		//3페이지 -> 21~30
		int end = numPerPage*reqPage;
		int start = end - numPerPage+1;
		
		ArrayList<Matching> list = dao.selectMatchingList(conn, start, end);
		return null;
	}
	
}

package semi.team.baro.history.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.history.model.dao.HistoryDao;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

public class HistoryService {
	
	private HistoryDao dao;

	public HistoryService() {
		super();
		dao = new HistoryDao();
	}

	public ArrayList<Mercenary> history(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Mercenary> mcList = dao.history(conn, memberNo);
		JDBCTemplate.close(conn);
		return mcList;
	}

	public ArrayList<MercenaryRequest> mercenaryRequsetHistory(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<MercenaryRequest> mcReq = dao.mercenaryRequestHistory(conn, memberNo);
		JDBCTemplate.close(conn);
		return mcReq;
	}
}

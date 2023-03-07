package semi.team.baro.blacklist.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.dao.BlacklistDao;
import semi.team.baro.blacklist.model.vo.Blacklist;

public class BlacklistService {
	private BlacklistDao dao;

	public BlacklistService() {
		super();
		dao = new BlacklistDao();
	}

	public int blacklistInsert(Blacklist bl) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.blacklistInsert(conn, bl);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
}

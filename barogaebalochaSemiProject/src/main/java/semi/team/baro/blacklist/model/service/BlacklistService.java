package semi.team.baro.blacklist.model.service;

import java.sql.Connection;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> main

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.dao.BlacklistDao;
import semi.team.baro.blacklist.model.vo.Blacklist;
<<<<<<< HEAD
import semi.team.baro.blacklist.model.vo.BlacklistPageData;
=======
>>>>>>> main

public class BlacklistService {
	private BlacklistDao dao;

	public BlacklistService() {
		super();
		dao = new BlacklistDao();
	}

<<<<<<< HEAD
	public BlacklistPageData adminBlacklistList(int reqPage) {
		// TODO Auto-generated method stub
		return null;
	}

=======
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
>>>>>>> main
	
}

package semi.team.baro.mercenary.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.dao.MercenaryDao;
import semi.team.baro.mercenary.model.vo.Mercenary;

public class MercenaryService {
	private MercenaryDao dao;

	public MercenaryService() {
		super();
		dao = new MercenaryDao();
	}

	public int mercenaryInsert(Mercenary m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.mercenaryInsert(conn, m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
}

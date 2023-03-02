package semi.team.baro.mercenary.model.service;

import java.sql.Connection;
import java.util.ArrayList;

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
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Mercenary> mercenarySelectAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Mercenary> list = dao.mercenarySelectAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Mercenary mercenaryView(int mercenaryNo) {
		Connection conn = JDBCTemplate.getConnection();
		Mercenary mc = dao.mercenaryView(conn, mercenaryNo);
		JDBCTemplate.close(conn);
		return mc;
	}
	
}
